package com.hermes.config;

import com.hermes.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liuzongbin
 * @version 1.0
 * @date 2021/9/10
 */
@Configuration
public class MyConfig {

	@Bean("myUser")
	public User userBean() {
		return new User();
	}
}
