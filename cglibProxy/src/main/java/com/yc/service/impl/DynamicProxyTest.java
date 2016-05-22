package com.yc.service.impl;


import org.junit.Test;


public class DynamicProxyTest {

	@Test
	public void testDynamicProxy() {
		CglibProxy cglib=new CglibProxy();
		
		UserManagerImpl um=(UserManagerImpl) cglib.getInstance(new UserManagerImpl());  
		um.addUser("song", "123456");
		um.findUser("1");
	}

}
