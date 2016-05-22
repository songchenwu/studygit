package com.yc.us.mapper;

import java.util.List;

import com.yc.us.entity.User;

public interface UserMapper {

	List<User> listUser();

	User getUserById(int id);

	void modyfyUser(User user);
	
	
}
