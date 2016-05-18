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
	
	//�첽���������Բ���������Ҫ��תҳ��   ��������ʹ��void ,���߷�������ΪStringʱ������"none";
	public String getTypes(){
		List<FilmType> types = typeService.getTypes();
		Gson gson=new Gson();//json�������
		String jsonResult=gson.toJson(types);//�Ѷ���ת��Ϊjson����
		LogManager.getLogger().debug("\n���ɵ�json�ַ���==>"+jsonResult);
		
		try {
			//������ҳ����ת�����������������ҳ��
			HttpServletResponse response=ServletActionContext.getResponse();
			response.setCharacterEncoding("utf-8");
			response.setContentType("charset=utf-8");
			PrintWriter out= response.getWriter(); //ȡ����Ӧ����
			out.print(jsonResult); //д����Ӧ����
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "none"; //��ʾ����תҳ��
	}
}
