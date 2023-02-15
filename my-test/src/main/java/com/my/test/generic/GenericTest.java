package com.my.test.generic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;

import java.io.IOException;
import java.util.Locale;

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
		context.refresh();
		UserService userService = context.getBean("userService", UserService.class);
		Assertions.assertNotNull(userService);
	}

	@Test
	public void testBeanFactory(){
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		RootBeanDefinition rbd = new RootBeanDefinition(UserService.class);
		beanFactory.registerBeanDefinition("userService", rbd);
		UserService userService = beanFactory.getBean("userService", UserService.class);
		Assertions.assertNotNull(userService);
	}

	@Test
	public void testMessageSource(){
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("message");
		Assertions.assertEquals("阿紫", messageSource.getMessage("name", null, Locale.getDefault()));
		Assertions.assertEquals("azi", messageSource.getMessage("name", null, Locale.US));
	}

	@Test
	public void testGetResource() throws IOException {
		DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
		Resource resource = resourceLoader.getResource("https://zijiancode.cn");
		resource = resourceLoader.getResource("classpath:com/my/test/generic/UserService.class");
		Assertions.assertEquals("UserService.class", resource.getFilename());
	}

	@Test
	public void testMetaReader() throws IOException {
		SimpleMetadataReaderFactory simpleMetadataReaderFactory = new SimpleMetadataReaderFactory();

		// 构造一个MetadataReader
		MetadataReader metadataReader = simpleMetadataReaderFactory.getMetadataReader("com.my.test.generic.UserService");

		// 得到一个ClassMetadata，并获取了类名
		ClassMetadata classMetadata = metadataReader.getClassMetadata();

		System.out.println(classMetadata.getClassName());

		// 获取一个AnnotationMetadata，并获取类上的注解信息
		AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
		for (String annotationType : annotationMetadata.getAnnotationTypes()) {
			System.out.println(annotationType);
		}
	}
}
