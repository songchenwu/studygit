package com.yc.vote.mapper;

import com.yc.vote.entity.User;

public interface UserMapper {

	User getUser(User user);//µÇÂ¼

	void reg(User user);//×¢²á
	
	User findEmail(User user);//¸ù¾İÓÊÏä²éÕÒ
    
	void changeStatus(User user);//ĞŞ¸Ä×´Ì¬
}