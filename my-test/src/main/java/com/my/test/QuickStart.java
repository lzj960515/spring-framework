package com.my.test;

import com.my.test.convert.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Zijian Liao
 * @since 1.0.0
 */
public class QuickStart {


	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		UserService userService = context.getBean("userService", UserService.class);
		userService.test();
	}

}