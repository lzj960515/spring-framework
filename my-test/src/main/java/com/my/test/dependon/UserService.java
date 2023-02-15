package com.my.test.dependon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author Zijian Liao
 * @since 1.0.0
 */
@Component
public class UserService {

	@Lazy
	@Autowired
	public OrderService orderService;

}
