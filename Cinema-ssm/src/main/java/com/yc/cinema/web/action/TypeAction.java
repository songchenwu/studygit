package com.yc.cinema.web.action;

import java.util.List;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.yc.cinema.entity.FilmType;
import com.yc.cinema.service.TypeService;
@Controller("typeAction")
public class TypeAction {
	@Autowired
	private TypeService typeService;
	private List<FilmType> filmTypes;
	
	public List<FilmType> getFilmTypes() {
		return filmTypes;
	}
	
	//异步请求处理，所以不许下新需要跳转页面   返回类型使用void ,或者返回类型为String时，返回"none";
	public String getTypes(){
		filmTypes = typeService.getTypes();
		return "none"; //表示不跳转页面
	}
}
