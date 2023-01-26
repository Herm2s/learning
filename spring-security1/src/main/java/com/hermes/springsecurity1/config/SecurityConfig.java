package com.hermes.springsecurity1.config;

import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.context.SecurityContextRepository;

/**
 * @author liu.zongbin
 * @since 2023/1/18
 */
@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Resource(name = "frameworkJwtSecurityContextRepository")
    private SecurityContextRepository securityContextRepository;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http,
                                                   AuthenticationSuccessHandler successHandler,
                                                   AuthenticationFailureHandler failureHandler,
                                                   AuthenticationEntryPoint authenticationEntryPoint) throws Exception {
        http.formLogin()
                // 配置表单登录的用户名密码参数和登录地址
                .usernameParameter("username")
                .passwordParameter("password")
                .loginProcessingUrl("/login")
                // 配置认证成功和失败处理器
                .successHandler(successHandler)
                .failureHandler(failureHandler)
                .and()
                // 关闭csrf
                .csrf()
                .disable()
                // 配置所有请求都需要认证
                .authorizeHttpRequests()
                .anyRequest()
                .authenticated()
                .and()
                // 配置身份认证入口点，请求需要认证时会跳到入口点
                .exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint)
                .and()
                .securityContext()
                .securityContextRepository(securityContextRepository);

        // 短信验证码登录配置
//        SmsCodeLoginConfigurer<HttpSecurity> smsCodeLoginConfigurer = new SmsCodeLoginConfigurer<>();
//        smsCodeLoginConfigurer.loginProcessingUrl("/smsCodeLogin")
//                .successHandler(successHandler)
//                .failureHandler(failureHandler);
//        http.apply(smsCodeLoginConfigurer);
//        http.authenticationProvider(smsCodeAuthenticationProvider)
//                .addFilterBefore(smsCodeLoginConfigurer.getAuthFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

}
