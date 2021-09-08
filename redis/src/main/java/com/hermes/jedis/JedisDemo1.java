package com.hermes.jedis;

import org.junit.jupiter.api.Test;
import redis.clients.jedis.DefaultJedisClientConfig;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * @author liuzongbin
 * @version 1.0
 * @date 2021/9/8
 */
public class JedisDemo1 {

    public static void main(String[] args) {

        // 创建Jedis对象
        Jedis jedis = new Jedis(new HostAndPort("127.0.0.1", 6379),
                DefaultJedisClientConfig.builder()
                        .password("123456")
                        .build());
        // 测试
        String value = jedis.ping();
        System.out.println(value);
    }

    @Test
    public void demo1() {
        // 创建Jedis对象
        Jedis jedis = new Jedis(new HostAndPort("127.0.0.1", 6379),
                DefaultJedisClientConfig.builder()
                        .password("123456")
                        .build());
        jedis.set("test", "java");
        Set<String> keys = jedis.keys("*");
        System.out.println(keys);
    }
}
