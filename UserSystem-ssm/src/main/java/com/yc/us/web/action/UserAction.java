package com.yc.us.web.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;
import com.yc.us.entity.User;
import com.yc.us.service.UserService;

@Controller("userAction")
public class UserAction implements ModelDriven<User>,SessionAware,RequestAware{
	@Autowired
	private UserService userService;
	private Map<String, Object> request;
	private Map<String, Object> session;
	private User user;
	
	public String list(){
		List<User> users=userService.listUser(user);
		session.put("users", users);//�����ݴ��뵽���ݿ���
		return "list";
	}
	
	public String detail(){
		user= userService.detailUserInfo(user);
		request.put("user",user);
		return "detail";
	}
	
	public String update(){
		user= userService.detailUserInfo(user);
		session.put("user", user);//�����ݴ��뵽���ݿ���
		return "update";
	}
	
	public String doupdate(){
		userService.modifyUserInfo(user);
		if(user!=null){
			return "success";
		}
		session.put("errorMsg", "��������ʧ�ܣ���");
		return "fail";
	}
	
	@Override //ModelDriven<User>עֵ
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
