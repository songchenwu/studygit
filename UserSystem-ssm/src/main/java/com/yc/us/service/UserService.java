package com.yc.us.service;

import java.util.List;

import com.yc.us.entity.User;

public interface UserService {
	
	//�г����е��û���Ϣ
	List<User> listUser(User user);

	//�����û�Id�ҳ��û�
	User detailUserInfo(User user);
	
	//����
	void modifyUserInfo(User user);
}
