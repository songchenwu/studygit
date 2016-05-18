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
	
	//�첽���������Բ���������Ҫ��תҳ��   ��������ʹ��void ,���߷�������ΪStringʱ������"none";
	public String getTypes(){
		filmTypes = typeService.getTypes();
		return "none"; //��ʾ����תҳ��
	}
}
