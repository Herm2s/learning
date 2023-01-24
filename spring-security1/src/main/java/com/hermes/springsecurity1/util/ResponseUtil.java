package com.hermes.springsecurity1.util;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONWriter;
import com.hermes.springsecurity1.exception.FrameworkException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author liu.zongbin
 * @since 2023/1/23
 */
@Component
public final class ResponseUtil {

    public static void responseJson(HttpServletResponse response, JsonResult<?> jsonResult) {
        response.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        try {
            response.getWriter().write(
                    JSON.toJSONString(jsonResult, JSONWriter.Feature.WriteNulls)
            );
        } catch (IOException e) {
            throw new FrameworkException("序列化JSON异常：" + e.getMessage(), e);
        }
    }
}
