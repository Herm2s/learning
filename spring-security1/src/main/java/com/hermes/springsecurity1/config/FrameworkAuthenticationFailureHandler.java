package com.hermes.springsecurity1.config;

import com.hermes.springsecurity1.util.JsonResult;
import com.hermes.springsecurity1.util.ResponseUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 认证失败处理器
 *
 * @author liu.zongbin
 * @since 2023/1/23
 */
@Slf4j
@Component
public class FrameworkAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        log.warn("登录失败：{}", exception.getMessage());
        ResponseUtil.responseJson(response, JsonResult.failure("登录失败：" + exception.getMessage()));
    }
}
