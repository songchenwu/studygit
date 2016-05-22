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
		List<Tag> tags=tagService.findAllTags();//ȡ�����б�ǩ
		List<Favorite> favorites =favoriteService.findAllFavorites();//ȡ��������վ��Ϣ
		session.put("tags",tags);
		session.put("favotites",favorites);
		return "list";
	}
	
	//�첽���󣬲�ֱ����תҳ�棬���Բ���Ҫ�����ַ���
	public void  listFav(){
		LogManager.getLogger().debug("ȡ����tname==��"+tname);
		
		//ȡ����Ӧ���ݣ�������ǩid ȡ����Ӧ����վ
		List<Favorite> favs=favoriteService.findFavoriteByTagId(tname);
		
		Gson gson=new Gson();//�Ѷ�����json�ַ���ת���ɶ���
		String jsonResult=gson.toJson(favs);//�Ѷ���ת����json�ַ���
		
		//ȡ����Ӧ����
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("charset=utf-8");
		
		try {
			PrintWriter out=response.getWriter();
			//out.println("{\"msg\":\"�ҽ�����~\"}");//�����Ƿ���ҳ����ͨ
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
