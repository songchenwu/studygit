package com.yc.cinema.web.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.yc.cinema.entity.FilmType;
import com.yc.cinema.service.TypeService;
import com.yc.cinema.service.impl.TypeServiceImpl;
@Controller("typeAction02")
public class TypeAction02 {
	@Autowired
	private TypeService typeService;
	
	public TypeAction02(){
		typeService=new TypeServiceImpl();
	}
	
	//异步请求处理，所以不许下新需要跳转页面   返回类型使用void ,或者返回类型为String时，返回"none";
	public String getTypes(){
		List<FilmType> types = typeService.getTypes();
		Gson gson=new Gson();//json处理对象
		String jsonResult=gson.toJson(types);//把对象转换为json对象
		LogManager.getLogger().debug("\n换成的json字符串==>"+jsonResult);
		
		try {
			//不进行页面跳转，输出数据流给请求页面
			HttpServletResponse response=ServletActionContext.getResponse();
			response.setCharacterEncoding("utf-8");
			response.setContentType("charset=utf-8");
			PrintWriter out= response.getWriter(); //取到响应对象
			out.print(jsonResult); //写出响应数据
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "none"; //表示不跳转页面
	}
}
