package com.my.test.convert;

/**
 * @author Zijian Liao
 * @since 1.0.0
 */
public class User {

	private String name;

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User{" +
				"name='" + name + '\'' +
				'}';
	}
}
