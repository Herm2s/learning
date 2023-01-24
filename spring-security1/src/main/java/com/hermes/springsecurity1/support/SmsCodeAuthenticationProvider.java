package com.hermes.springsecurity1.support;

import cn.hutool.core.lang.Assert;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * 短信登录认证提供器
 *
 * @author liu.zongbin
 * @since 2023/1/23
 */
@Slf4j
@Component
public class SmsCodeAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String mobile = (String) authentication.getPrincipal();
        String code = (String) authentication.getCredentials();

        log.info("手机号【{}】验证码【{}】开始登录", mobile, code);
        Assert.isTrue("123456".equals(code), () -> new BadCredentialsException("验证码错误"));

        return SmsCodeAuthenticationToken.authenticated(mobile, code);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return SmsCodeAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
