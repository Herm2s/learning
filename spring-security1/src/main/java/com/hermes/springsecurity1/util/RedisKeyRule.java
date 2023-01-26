package com.hermes.springsecurity1.util;

import lombok.experimental.UtilityClass;

/**
 * @author liu.zongbin
 * @since 2023/1/24
 */
@UtilityClass
public class RedisKeyRule {

    public String accessTokenKey(String accessToken) {
        return "security:authentication:" + accessToken;
    }
}
