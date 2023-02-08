package com.hermes.config;

import cn.hutool.core.util.StrUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liu.zongbin
 * @since 2023/2/7
 */
@RestController
@RefreshScope
@RequiredArgsConstructor
public class AppController {

    private final AppClient appClient;

    private final AppProperties appProperties;

    @Value("${app.appName}")
    private String appName;

    @GetMapping("/app")
    public String app() {
        String template = """
                @Value: {},
                appProperties: {}
                """;
        return StrUtil.format(template, appName, this.appProperties.getAppName());
    }
}
