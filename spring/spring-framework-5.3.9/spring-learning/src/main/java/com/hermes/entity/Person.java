package com.hermes.entity;

import java.util.StringJoiner;

/**
 * @author liuzongbin
 * @version 1.0
 * @date 2021/9/10
 */
public class Person {

	private Long id;

	private String name;

	private String address;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", Person.class.getSimpleName() + "[", "]")
				.add("id=" + id)
				.add("name='" + name + "'")
				.add("address='" + address + "'")
				.toString();
	}
}
