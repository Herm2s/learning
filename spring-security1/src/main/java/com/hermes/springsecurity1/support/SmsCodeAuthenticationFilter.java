package com.hermes.springsecurity1.support;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

/**
 * 短信验证登录过滤器
 *
 * @author liu.zongbin
 * @since 2023/1/23
 */
public class SmsCodeAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    public SmsCodeAuthenticationFilter() {
        super("/smsCodeLogin");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        // 创建token
        String mobile = request.getParameter("mobile");
        String code = request.getParameter("code");
        SmsCodeAuthenticationToken token = SmsCodeAuthenticationToken.unauthenticated(mobile, code);
        token.setDetails(this.authenticationDetailsSource.buildDetails(request));

        // 认证
        return this.getAuthenticationManager().authenticate(token);
    }
}
