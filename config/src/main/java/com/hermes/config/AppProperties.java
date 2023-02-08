package com.hermes.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author liu.zongbin
 * @since 2023/2/7
 */
@Data
@ConfigurationProperties(prefix = "app")
public class AppProperties {

    private String appId;

    private String appName;
}
