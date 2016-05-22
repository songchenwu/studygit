package com.yc.us.service;

import java.util.List;

import com.yc.us.entity.User;

public interface UserService {
	
	//列出所有的用户信息
	List<User> listUser(User user);

	//根据用户Id找出用户
	User detailUserInfo(User user);
	
	//更新
	void modifyUserInfo(User user);
}
