package com.my.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Zijian Liao
 * @since 1.0.0
 */
@Configuration
@ComponentScan
public class QuickStart {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(QuickStart.class);
	}
}
