package com.hermes.demo;

import com.hermes.config.MyConfig;
import com.hermes.entity.User;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * ConfigurationClassBeanDefinition测试
 *
 * @author liuzongbin
 * @version 1.0
 * @date 2021/9/10
 */
public class Demo5 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
		BeanDefinition myUser = context.getBeanFactory().getBeanDefinition("myUser");
		User myUser1 = (User)context.getBean("myUser");
		System.out.println(myUser);
		System.out.println(myUser1);
	}
}
