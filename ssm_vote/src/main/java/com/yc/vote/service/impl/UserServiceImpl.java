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
			userMapper.reg(user);//����û��ɹ�
			//userMapper.findEmail(user);//��ѯ����
			return user;
		} catch (Exception e) {
			throw new RuntimeException("����ʧ��",e);
		}
		
	}
	

}
