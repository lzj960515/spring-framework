package com.my.test.convert;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Zijian Liao
 * @since 1.0.0
 */
@Component
public class UserService {

	@Value("张三")
	private User user;

	public void test(){
		System.out.println(user);
	}
}
