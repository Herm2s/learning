package com.hermes.spring3.config;

import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author liu.zongbin
 * @since 2023/2/20
 */
@Component
public class AppFactoryBean extends AbstractFactoryBean<MyBean> {

    @Override
    protected MyBean createInstance() {
        return new MyBean();
    }

    @Override
    public Class<?> getObjectType() {
        return MyBean.class;
    }
}
