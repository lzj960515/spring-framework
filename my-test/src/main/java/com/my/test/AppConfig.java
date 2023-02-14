package com.my.test;

import com.my.test.convert.StringToUserConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;

import java.util.Collections;

/**
 * @author Zijian Liao
 * @since 1.0.0
 */
@ComponentScan("com.my.test")
@Configuration
public class AppConfig {

	@Bean
	public ConversionServiceFactoryBean conversionService() {
		ConversionServiceFactoryBean conversionServiceFactoryBean = new ConversionServiceFactoryBean();
		conversionServiceFactoryBean.setConverters(Collections.singleton(new StringToUserConverter()));

		return conversionServiceFactoryBean;
	}
}
