package com.hermes.distributed.lock.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hermes.distributed.lock.mapper.StockMapper;
import com.hermes.distributed.lock.pojo.Stock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liu.zongbin
 * @since 2022/8/30 21:49
 */
@Service
@RequiredArgsConstructor
public class StockService {

    private final StockMapper stockMapper;

    private ReentrantLock lock = new ReentrantLock();

    public void deduct() {
        try {
            Stock stock = this.stockMapper.selectOne(Wrappers.lambdaQuery(Stock.class)
                    .eq(Stock::getProductCode, "1001"));
            this.lock.lock();
        } finally {
            this.lock.unlock();
        }
    }
}
