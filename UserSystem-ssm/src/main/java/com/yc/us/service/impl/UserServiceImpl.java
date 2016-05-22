package com.yc.us.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.us.entity.User;
import com.yc.us.mapper.UserMapper;
import com.yc.us.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	
	
	@Override
	public List<User> listUser(User user) {
		LogManager.getLogger().debug("取到的user》"+user);
		return userMapper.listUser();
	}

	@Override
	public User detailUserInfo(User user) {
		LogManager.getLogger().debug("取到的id》"+user.getId());
		return userMapper.getUserById(user.getId());
	}

	@Override
	public void modifyUserInfo(User user) {
		LogManager.getLogger().debug("取到的id》"+user.getId());
		
		userMapper.modyfyUser(user);
	}
}
