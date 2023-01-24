package com.hermes.springsecurity1.support;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

/**
 * @author liu.zongbin
 * @since 2023/1/23
 */
public class SmsCodeLoginConfigurer<H extends HttpSecurityBuilder<H>>
        extends AbstractAuthenticationFilterConfigurer<H, SmsCodeLoginConfigurer<H>, SmsCodeAuthenticationFilter> {

    public SmsCodeLoginConfigurer() {
        super(new SmsCodeAuthenticationFilter(), null);
    }

    @Override
    protected RequestMatcher createLoginProcessingUrlMatcher(String loginProcessingUrl) {
        return new AntPathRequestMatcher(loginProcessingUrl, HttpMethod.POST.name());
    }

    public SmsCodeAuthenticationFilter getAuthFilter() {
        return super.getAuthenticationFilter();
    }
}
