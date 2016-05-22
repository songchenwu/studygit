package com.yc.fav.web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ModelDriven;
import com.yc.fav.entity.Favorite;
import com.yc.fav.entity.Tag;
import com.yc.fav.service.FavoriteService;
import com.yc.fav.service.TagService;
@Controller("favoriteAction")
public class FavoriteAction implements SessionAware,ModelDriven<Favorite>{
	@Autowired
	private TagService tagService;
	@Autowired
	private FavoriteService favoriteService;
	private Map<String, Object> session;
	private String tname;
	private Favorite favorite;
	
	public void setTname(String tname) {
		this.tname = tname;
	}
	

	public String list(){
		List<Tag> tags=tagService.findAllTags();//取到所有标签
		List<Favorite> favorites =favoriteService.findAllFavorites();//取到所有网站信息
		session.put("tags",tags);
		session.put("favotites",favorites);
		return "list";
	}
	
	//异步请求，不直接跳转页面，所以不需要返回字符串
	public void  listFav(){
		LogManager.getLogger().debug("取到的tname==》"+tname);
		
		//取到响应数据，根据书签id 取到对应的网站
		List<Favorite> favs=favoriteService.findFavoriteByTagId(tname);
		
		Gson gson=new Gson();//把对象与json字符串转换成对象
		String jsonResult=gson.toJson(favs);//把对象转换成json字符串
		
		//取到响应对象
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("charset=utf-8");
		
		try {
			PrintWriter out=response.getWriter();
			//out.println("{\"msg\":\"我进来了~\"}");//测试是否与页面连通
			out.println(jsonResult);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String  add(){
		try {
			favoriteService.addFavorite(favorite);
			return "success";
		} catch (Exception e) {
			return "fail";
		}
		
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

	@Override
	public Favorite getModel() {
		this.favorite=new Favorite();
		return favorite;
	}
}
