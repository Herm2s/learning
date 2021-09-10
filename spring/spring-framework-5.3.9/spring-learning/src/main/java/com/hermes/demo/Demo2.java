package com.hermes.demo;

import com.hermes.entity.Person;
import com.hermes.entity.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * @author liuzongbin
 * @version 1.0
 * @date 2021/9/10
 */
public class Demo2 {

	public static void main(String[] args) {
		DefaultListableBeanFactory context = new DefaultListableBeanFactory();
		MutablePropertyValues values = new MutablePropertyValues();
		values.add("id", 1L)
				.add("name", "hermes");
		GenericBeanDefinition parentGenericBeanDefinition = new GenericBeanDefinition();
		parentGenericBeanDefinition.setBeanClass(User.class);
		parentGenericBeanDefinition.setPropertyValues(values);
		// 注册
		context.registerBeanDefinition("user", parentGenericBeanDefinition);

		GenericBeanDefinition childGenericBeanDefinition = new GenericBeanDefinition();
		childGenericBeanDefinition.setParentName("user");
		childGenericBeanDefinition.setBeanClass(Person.class);
		childGenericBeanDefinition.getPropertyValues().add("address", "上海市");
		// 注册
		context.registerBeanDefinition("person", childGenericBeanDefinition);

		User user = context.getBean(User.class);
		Person person = context.getBean(Person.class);
		System.out.println(user);
		System.out.println(person);
	}
}
