package com.yc.cinema.web.action;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;
import com.yc.cinema.entity.FilmBean;
import com.yc.cinema.entity.FilmInfo;
import com.yc.cinema.service.FilmService;
import com.yc.cinema.service.impl.FilmServiceImpl;
@Controller("filmAction")
public class FilmAction implements ModelDriven<FilmBean>,SessionAware{
	@Autowired
	private FilmService filmService;//电影业务处理对象
	private FilmBean filmBean;//接收请求数据
	private Map<String, Object> session;
	private List<FilmInfo> filmInfo;
	
	
	public List<FilmInfo> getFilmInfo() {
		return filmInfo;
	}

	public FilmAction(){
		filmService = new FilmServiceImpl();
	}
	
	public String search(){
		LogManager.getLogger().debug("取到的查询条件==》"+filmBean);
		List<FilmInfo> films= filmService.getFilmsByBean(filmBean);
		session.put("films", films);//把數據存入session,帶到页面显示
		return "success";
	}
	
	public String add(){
		int film =filmService.addFilmInfo(filmBean);
		session.put("film", film);//把數據存入session,帶到页面显示
		return "success";
	}
	@Override
	public FilmBean getModel() {
		filmBean = new FilmBean();
		return filmBean;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
		
	}

}
