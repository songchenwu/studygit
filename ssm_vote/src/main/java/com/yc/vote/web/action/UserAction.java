package com.yc.vote.web.action;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;
import com.yc.vote.entity.User;
import com.yc.vote.service.UserService;
import com.yc.vote.util.VoteData;

@Controller("userAction")
public class UserAction implements ModelDriven<User>,SessionAware,RequestAware{
	private User user;
	@Autowired
	private UserService userService;
	private Map<String, Object> session;
	private Map<String, Object> request;
	public String login(){
		LogManager.getLogger().debug("login登录操作");
		LogManager.getLogger().debug("login登录操作数据==>");
		user=userService.login(user);
		if(user==null){
			session.put(VoteData.ERROR_MSG, "用户名或密码错误");
			return "login";
		}
		session.put(VoteData.LOGIN_USER, user);
		return "loginSuccess";
	}
	
	public String register(){
		try {
			LogManager.getLogger().debug("注册操作");
			user=userService.register(user);
			if(null!=user){
				session.put("user", user);
				return "registerSuccess";
			}else{
				request.put("errMsg", "该用户已被注册！！！");
				return "registerFail";
			}
		}catch (Exception e) {
			request.put("errMsg", "该用户已被注册！！！");
			return "registerFail";
		}
	}

	@Override
	public User getModel() {
		user=new User();
		return user;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request=request;
		
	}
}
