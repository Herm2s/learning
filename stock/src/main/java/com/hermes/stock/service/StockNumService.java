package com.hermes.stock.service;

import com.hermes.stock.mapper.StockNumMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.connection.RedisCommandsProvider;
import org.springframework.data.redis.connection.ReturnType;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author liu.zongbin
 * @since 2023/2/6
 */
@Service
@RequiredArgsConstructor
public class StockNumService {

    private static final RedisScript<Long> SCRIPT = RedisScript.of("""
            local stock = redis.call("get", KEYS[1])
            if stock == false then
                return 0
            end
            if tonumber(stock) >= tonumber(ARGV[1]) then
                redis.call("decrby", KEYS[1], ARGV[1])
                return 1
            else
                return 0
            end
            """, Long.class);

    private final StockNumMapper stockNumMapper;

    private final StringRedisTemplate redisTemplate;

    public void reduce() {
        Long result = redisTemplate.execute(SCRIPT, List.of("stock"), "1");
//        Long result = redisTemplate.execute((RedisCallback<Long>) connection ->
//                (Long) connection.scriptingCommands()
//                        .eval(script.getBytes(), ReturnType.INTEGER, 1, "stock".getBytes(), "1".getBytes()));

        if (result == 1L) {
            // 库存扣减成功
            this.stockNumMapper.reduce(1L);
        }
    }

    private boolean pipeline() {
        List<Object> redisResult = this.redisTemplate.executePipelined((RedisCallback<Boolean>) connection -> {
            byte[] key = "stock".getBytes();
            Long stock = connection.stringCommands().decr(key);
            if (Optional.ofNullable(stock).orElse(-1L) < 0L) {
                connection.stringCommands().incr(key);
            }
            return null;
        });
        return (Long) redisResult.get(0) >= 0L;
    }
}
