package com.hermes.entity;

import java.util.StringJoiner;

/**
 * @author liuzongbin
 * @version 1.0
 * @date 2021/9/10
 */
public class User {

	private Long id;

	private String name;

	private Vip vip;

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

	public Vip getVip() {
		return vip;
	}

	public void setVip(Vip vip) {
		this.vip = vip;
	}

	@Override public String toString() {
		return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
				.add("id=" + id)
				.add("name='" + name + "'")
				.add("vip=" + vip)
				.toString();
	}

	/**
	 * 内部Bean测试
	 */
	public class Vip {

		private String vipLevel;

		public String getVipLevel() {
			return vipLevel;
		}

		public void setVipLevel(String vipLevel) {
			this.vipLevel = vipLevel;
		}

		@Override
		public String toString() {
			return new StringJoiner(", ", Vip.class.getSimpleName() + "[", "]")
					.add("vipLevel='" + vipLevel + "'")
					.toString();
		}
	}
}
