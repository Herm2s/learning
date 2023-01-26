package com.hermes.springsecurity1.security;

import cn.hutool.core.util.BooleanUtil;
import cn.hutool.core.util.StrUtil;
import com.hermes.springsecurity1.constant.SecurityConstant;
import com.hermes.springsecurity1.util.RedisKeyRule;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpRequestResponseHolder;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * 自定义Security Context Redis持久化
 *
 * @author liu.zongbin
 * @since 2023/1/24
 */
@Component
@RequiredArgsConstructor
public class FrameworkRedisSecurityContextRepository implements SecurityContextRepository {


    private final RedisTemplate<String, Object> redisTemplate;

    @SuppressWarnings("deprecation")
    @Override
    public SecurityContext loadContext(HttpRequestResponseHolder requestResponseHolder) {
        SecurityContext securityContext = SecurityContextHolder.createEmptyContext();

        HttpServletRequest request = requestResponseHolder.getRequest();
        String accessToken = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (StrUtil.isBlank(accessToken)) {
            return securityContext;
        }

        Authentication authentication = (Authentication) this.redisTemplate.opsForValue()
                .get(RedisKeyRule.accessTokenKey(accessToken));
        securityContext.setAuthentication(authentication);
        return securityContext;
    }

    @Override
    public void saveContext(SecurityContext context, HttpServletRequest request, HttpServletResponse response) {
        String accessToken = UUID.randomUUID().toString();
        redisTemplate.opsForValue().set(RedisKeyRule.accessTokenKey(accessToken), context.getAuthentication());
        // 将token设置到Request以便后续程序能拿到
        request.setAttribute(SecurityConstant.ACCESS_TOKEN_PARAM, accessToken);
    }

    @Override
    public boolean containsContext(HttpServletRequest request) {
        String accessToken = request.getHeader(HttpHeaders.AUTHORIZATION);
        return StrUtil.isNotBlank(accessToken) &&
                BooleanUtil.isTrue(redisTemplate.hasKey(RedisKeyRule.accessTokenKey(accessToken)));
    }

}
