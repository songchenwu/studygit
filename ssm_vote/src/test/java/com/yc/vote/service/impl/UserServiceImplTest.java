package com.yc.vote.service.impl;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.vote.entity.User;
import com.yc.vote.service.UserService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class UserServiceImplTest {
	@Autowired
	private UserService userService;
	@Test
	public void testLogin() {
		User user=new User(10000,"a");
		System.out.println(userService.login(user));
	}
	
	@Test
	public void testReg() {
		User user=new User();
		user.setVuUsername("aa");
		user.setVuPassword("aa");
		user.setVuEmail("11@qq.com");
		userService.register(user);
		
	}

}
