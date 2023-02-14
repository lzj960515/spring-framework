package com.my.test.generic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

/**
 * 测试Spring中的一些核心类
 * @author Zijian Liao
 * @since 1.0.0
 */
public class GenericTest {


	@Test
	public void testBeanDefinition(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(GenericTest.class);
		/*AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
		beanDefinition.setBeanClass(UserService.class);
		context.registerBeanDefinition("userService", beanDefinition);*/
		context.register(UserService.class);
		UserService userService = context.getBean("userService", UserService.class);
		Assertions.assertNotNull(userService);
	}

	@Test
	public void testScanner(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(context);
		scanner.scan("com.my.test.generic");
		context.refresh();
		UserService userService = context.getBean("userService", UserService.class);
		Assertions.assertNotNull(userService);
	}

	@Test
	public void testReader(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		AnnotatedBeanDefinitionReader annotatedBeanDefinitionReader = new AnnotatedBeanDefinitionReader(context);
		annotatedBeanDefinitionReader.register(UserService.class);
	}
}
