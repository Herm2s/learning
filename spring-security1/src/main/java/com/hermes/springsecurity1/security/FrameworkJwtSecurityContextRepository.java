package com.hermes.springsecurity1.security;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import com.hermes.springsecurity1.constant.SecurityConstant;
import com.hermes.springsecurity1.support.JwtAuthenticationToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.context.HttpRequestResponseHolder;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * @author liu.zongbin
 * @since 2023/1/24
 */
@Component
public class FrameworkJwtSecurityContextRepository implements SecurityContextRepository {

    public static final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(
            "404E635266556A286E3272357538782F413F4428472B4B6250645367966B5970".getBytes(StandardCharsets.UTF_8)
    );

    private static final JwtParser JWT_PARSER = Jwts.parserBuilder()
            .setSigningKey(SECRET_KEY)
            .build();

    @Override
    public SecurityContext loadContext(HttpRequestResponseHolder requestResponseHolder) {
        HttpServletRequest request = requestResponseHolder.getRequest();
        String accessToken = request.getHeader(HttpHeaders.AUTHORIZATION);

        SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
        if (StrUtil.isBlank(accessToken)) {
            return securityContext;
        }
        Claims claims = JWT_PARSER.parseClaimsJws(accessToken).getBody();
        JwtAuthenticationToken jwtToken = new JwtAuthenticationToken(
                MapUtil.getStr(claims, "userId"),
                AuthorityUtils.commaSeparatedStringToAuthorityList(MapUtil.getStr(claims, "authorities"))
        );
        securityContext.setAuthentication(jwtToken);
        return securityContext;
    }

    @Override
    public void saveContext(SecurityContext context, HttpServletRequest request, HttpServletResponse response) {
        UserDetails userDetails = (UserDetails) context.getAuthentication().getPrincipal();
        String accessToken = Jwts.builder()
                .signWith(SECRET_KEY)
                .claim("userId", userDetails.getUsername())
                .claim("authorities", String.join(",", AuthorityUtils.authorityListToSet(userDetails.getAuthorities())))
                .setExpiration(DateUtil.offsetMinute(new Date(), 300))
                .compact();
        // 将token设置到Request以便后续程序能拿到
        request.setAttribute(SecurityConstant.ACCESS_TOKEN_PARAM, accessToken);
    }

    @Override
    public boolean containsContext(HttpServletRequest request) {
        String accessToken = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (StrUtil.isBlank(accessToken)) {
            return false;
        }
        try {
            JWT_PARSER.parseClaimsJws(accessToken);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
