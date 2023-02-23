package com.hermes.spring3.profile;

import com.hermes.spring3.config.MyBeanA;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author liu.zongbin
 * @since 2023/2/22
 */
@Configuration
public class ProfileConfig {

    @Bean
    @Profile("prd")
    public MyBeanA myBeanA() {
        return new MyBeanA("a");
    }

    @Bean
    @Profile("dev")
    public MyBeanA myBeanB() {
        return new MyBeanA("b");
    }
}
