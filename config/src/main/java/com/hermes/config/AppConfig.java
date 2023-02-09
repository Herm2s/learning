package com.hermes.config;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.nacos.api.config.ConfigChangeEvent;
import com.alibaba.nacos.client.config.listener.impl.AbstractConfigChangeListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

/**
 * @author liu.zongbin
 * @since 2023/2/7
 */
@Slf4j
@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(AppProperties.class)
public class AppConfig {

    private final AppProperties appProperties;

    private final NacosConfigManager nacosConfigManager;

    @Bean
    public AppClient appClient() {
        AppClient appClient = new AppClient();
        appClient.setAppId(appProperties.getAppId());
        appClient.setAppName(appProperties.getAppName());
        return appClient;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void refresh() throws Exception {
        AbstractConfigChangeListener listener = new AbstractConfigChangeListener() {
            @Override
            public void receiveConfigChange(ConfigChangeEvent event) {
//                Collection<ConfigChangeItem> changeItems = event.getChangeItems();
//                log.info(changeItems.toString());
                log.info("app Name: {}", appProperties.getAppName());

            }
        };
        this.nacosConfigManager
                .getConfigService()
                .addListener("config.yml", "DEFAULT_GROUP", listener);
    }
}
