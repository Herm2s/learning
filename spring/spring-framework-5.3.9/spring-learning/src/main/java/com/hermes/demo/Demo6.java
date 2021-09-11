package com.hermes.demo;

import com.hermes.entity.User;
import org.springframework.beans.factory.support.AbstractBeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author liuzongbin
 * @version 1.0
 * @date 2021/9/10
 */
public class Demo6 {

	public static void main(String[] args) {
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		AbstractBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		int i = reader.loadBeanDefinitions("spring-config.xml");
		System.out.println("本次加载的Bean数量" + i);

		// 根据名称获取Bean
		User user = (User)factory.getBean("user");
		System.out.println("user: " + user);
		User.Vip vip = user.getVip();
		System.out.println("vip: " + vip.getVipLevel());

		// 根据别名获取Bean
		User user1 = (User)factory.getBean("user1");
		System.out.println("user1: " + user1);
		User user2 = (User)factory.getBean("user2");
		System.out.println("user2: " + user2);

		// 根据bean名称获取别名数组
		String[] users = factory.getAliases("user");
		for (String s : users) {
			System.out.println(s);
		}
	}
}
