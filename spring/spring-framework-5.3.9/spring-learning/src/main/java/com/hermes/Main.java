package com.hermes;

import com.hermes.entity.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * @author liuzongbin
 * @version 1.0
 * @date 2021/9/10
 */
public class Main {
	public static void main(String[] args) {
		DefaultListableBeanFactory context = new DefaultListableBeanFactory();
		MutablePropertyValues values = new MutablePropertyValues();
		values.add("id", 1L);
		values.add("name", "hermes");
		RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(User.class, null, values);
		context.registerBeanDefinition("user", rootBeanDefinition);
		User user = (User)context.getBean("user");
		System.out.println(user);
	}
}
