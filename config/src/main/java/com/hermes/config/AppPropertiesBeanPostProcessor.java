package com.hermes.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author liu.zongbin
 * @since 2023/2/9
 */
@Slf4j
@Component
public class AppPropertiesBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof AppProperties properties) {
            log.info("post: " + properties.getAppName());
        }
        return bean;
    }
}
