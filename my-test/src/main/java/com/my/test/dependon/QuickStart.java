package com.my.test.dependon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Zijian Liao
 * @since 1.0.0
 */
@ComponentScan
@Configuration
public class QuickStart {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(QuickStart.class);
		Object userService = context.getBean("userService");
		System.out.println(((UserService)userService).orderService);
	}

}
