package com.yc.vote.mapper;

import com.yc.vote.entity.User;

public interface UserMapper {

	User getUser(User user);//��¼

	void reg(User user);//ע��
	
	User findEmail(User user);//�����������
    
	void changeStatus(User user);//�޸�״̬
}