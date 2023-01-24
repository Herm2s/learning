package com.hermes.springsecurity1.config;

import com.hermes.springsecurity1.util.JsonResult;
import com.hermes.springsecurity1.util.ResponseUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 认证成功处理器
 *
 * @author liu.zongbin
 * @since 2023/1/23
 */
@Slf4j
@Component
public class FrameworkAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        log.info("{} 登录成功", authentication.getPrincipal());
        ResponseUtil.responseJson(response, JsonResult.success("登录成功"));
    }
}
