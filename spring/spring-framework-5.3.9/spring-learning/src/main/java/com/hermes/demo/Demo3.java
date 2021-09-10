package com.hermes.demo;

import com.hermes.config.AppConfig;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * ScannedGenericBeanDefinition测试
 *
 * @author liuzongbin
 * @version 1.0
 * @date 2021/9/10
 */
public class Demo3 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		BeanDefinition helloController = context.getBeanFactory().getBeanDefinition("helloController");
		System.out.println();
	}
}
