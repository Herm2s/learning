package com.hermes.distributed.lock.service;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.hermes.distributed.lock.mapper.StockMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liu.zongbin
 * @since 2022/8/30 21:49
 */
@Service
@RequiredArgsConstructor
public class StockService {

    private final StockMapper stockMapper;

    private final StringRedisTemplate redisTemplate;

    private ReentrantLock reentrantLock = new ReentrantLock();

    public void deduct() {
        // 循环重试加锁
        while (!this.redisTemplate.opsForValue().setIfAbsent("lock", "111")) {
            try {
                TimeUnit.MILLISECONDS.sleep(50);
                this.deduct();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            // 1.查询库存信息
            String stock = redisTemplate.opsForValue().get("stock");
            // 2.判断库存是否充足
            if (stock != null && stock.length() > 0) {
                int st = Integer.parseInt(stock);
                if (st > 0) {
                    // 3.扣减库存
                    redisTemplate.opsForValue().set("stock", String.valueOf(--st));
                }
            }
        } finally {
            // 解锁
            this.redisTemplate.delete("lock");
        }
    }


    /**
     * redis事务锁库存
     */
    public void deduct4() {
        this.redisTemplate.execute(new SessionCallback<Object>() {
            @Override
            public Object execute(RedisOperations operations) throws DataAccessException {
                // watch
                operations.watch("stock");
                // 1.查询库存信息
                String stock = Objects.requireNonNull(operations.opsForValue().get("stock")).toString();

                // 2.判断库存是否充足
                if (stock != null && stock.length() > 0) {
                    Integer st = Integer.valueOf(stock);
                    if (st > 0) {
                        // multi
                        operations.multi();
                        operations.opsForValue().set("stock", String.valueOf(--st));
                        // exec
                        List exec = operations.exec();
                        if (CollectionUtils.isEmpty(exec)) {
                            // 重试
                            try {
                                TimeUnit.MILLISECONDS.sleep(40);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            deduct();
                        }
                        return exec;
                    }
                }
                return null;
            }
        });
    }
}