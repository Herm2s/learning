package com.hermes.demo;

import com.hermes.entity.Person;
import com.hermes.entity.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.ChildBeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * @author liuzongbin
 * @version 1.0
 * @date 2021/9/10
 */
public class Demo1 {

	public static void main(String[] args) {
		DefaultListableBeanFactory context = new DefaultListableBeanFactory();
		MutablePropertyValues values = new MutablePropertyValues();
		values.add("id", 1L)
				.add("name", "hermes");
		RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(User.class, null, values);
		// 注册
		context.registerBeanDefinition("user", rootBeanDefinition);

		MutablePropertyValues childValues = new MutablePropertyValues();
		childValues.add("address", "上海市");
		ChildBeanDefinition childBeanDefinition = new ChildBeanDefinition("user", Person.class, null, childValues);
		// 注册
		context.registerBeanDefinition("person", childBeanDefinition);

		User user = context.getBean(User.class);
		Person person = context.getBean(Person.class);
		System.out.println(user);
		System.out.println(person);
	}
}
