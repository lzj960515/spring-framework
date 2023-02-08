package com.my.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Zijian Liao
 * @since 1.0.0
 */
@Configuration
public class QuickStart {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(QuickStart.class);
		System.out.println(context.getBean("user"));
	}

	@Bean
	public User user(){
		return new User();
	}

	static class User {
		String name;
	}
}
