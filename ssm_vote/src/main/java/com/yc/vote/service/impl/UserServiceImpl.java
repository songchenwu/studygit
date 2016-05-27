package com.yc.vote.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.vote.entity.User;
import com.yc.vote.mapper.UserMapper;
import com.yc.vote.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Override
	public User login(User user) {
		System.out.println(user);
		return userMapper.getUser(user);
	}
	@Override
	public User register(User user) {
		try {
			userMapper.reg(user);//添加用户成功
			//userMapper.findEmail(user);//查询邮箱
			return user;
		} catch (Exception e) {
			throw new RuntimeException("插入失败",e);
		}
		
	}
	

}
