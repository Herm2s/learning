package com.hermes.demo;

import com.hermes.config.MyConfig;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * AnnotatedGenericBeanDefinition测试
 *
 * @author liuzongbin
 * @version 1.0
 * @date 2021/9/10
 */
public class Demo4 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
		BeanDefinition myConfig = context.getBeanFactory().getBeanDefinition("myConfig");
		System.out.println(myConfig);
	}
}
