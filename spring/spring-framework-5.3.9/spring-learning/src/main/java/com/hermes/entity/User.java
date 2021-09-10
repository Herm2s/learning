package com.hermes.entity;

/**
 * @author liuzongbin
 * @version 1.0
 * @date 2021/9/10
 */
public class User {

	private Long id;

	private String name;

	public void init() {
		System.out.println("初始化");
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
