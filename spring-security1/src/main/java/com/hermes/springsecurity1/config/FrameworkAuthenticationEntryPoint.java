package com.hermes.springsecurity1.config;

import com.hermes.springsecurity1.util.JsonResult;
import com.hermes.springsecurity1.util.ResponseUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 认证入口
 *
 * @author liu.zongbin
 * @since 2023/1/23
 */
@Slf4j
@Component
public class FrameworkAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        log.warn("需要认证：{}", authException.getMessage());
        ResponseUtil.responseJson(response, JsonResult.failure("请登录"));
    }
}
