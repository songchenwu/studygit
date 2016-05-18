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
	private FilmService filmService;//��Ӱҵ�������
	private FilmBean filmBean;//������������
	private Map<String, Object> session;
	private List<FilmInfo> filmInfo;
	
	
	public List<FilmInfo> getFilmInfo() {
		return filmInfo;
	}

	public FilmAction(){
		filmService = new FilmServiceImpl();
	}
	
	public String search(){
		LogManager.getLogger().debug("ȡ���Ĳ�ѯ����==��"+filmBean);
		List<FilmInfo> films= filmService.getFilmsByBean(filmBean);
		session.put("films", films);//�є�������session,����ҳ����ʾ
		return "success";
	}
	
	public String add(){
		int film =filmService.addFilmInfo(filmBean);
		session.put("film", film);//�є�������session,����ҳ����ʾ
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
