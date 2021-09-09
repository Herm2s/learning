package com.hermes.service.impl;

import com.hermes.service.SecondKillService;
import org.springframework.stereotype.Service;
import redis.clients.jedis.DefaultJedisClientConfig;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;

/**
 * @author liuzongbin
 * @version 1.0
 * @date 2021/9/9
 */
@Service
public class SecondKillServiceImpl implements SecondKillService {

    @Override
    public boolean secondKill(Integer userId, Integer goodId) {
        Jedis jedis = new Jedis(new HostAndPort("127.0.0.1", 6380), DefaultJedisClientConfig.builder()
            .password("cacheManager1@#")
            .database(15)
            .build());
        // 验证参数
        if (userId == null || goodId == null) {
            return false;
        }
        String goodKey = "good:" + goodId;
        String userKey = "good:" + goodId + ":user";
        String strStock = jedis.get(goodKey);
        // 秒杀是否开始
        if (strStock == null) {
            return false;
        }
        int stock = Integer.parseInt(strStock);
        // 库存是否足够
        if (stock < 1) {
            return false;
        }
        jedis.decr(goodKey);
        jedis.sadd(userKey, userId.toString());
        return true;
    }
}
