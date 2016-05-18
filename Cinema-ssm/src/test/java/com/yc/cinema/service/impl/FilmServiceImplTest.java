package com.yc.cinema.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.cinema.entity.FilmBean;
import com.yc.cinema.entity.FilmInfo;
import com.yc.cinema.service.FilmService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class FilmServiceImplTest {
	@Autowired
	private FilmService filmService;

	@Test
	public void testGetFilmsByBean() {
		FilmBean fb=new FilmBean();
		//fb.setFilmname("��");
		//fb.setActor("л����");
		fb.setDirector("�¹���");
		//fb.setMinprice(20.0);
		//fb.setMaxprice(100.0);
		List<FilmInfo> fis=filmService.getFilmsByBean(fb);
		System.out.println(fis);
		assertNotNull(fis);
	}
	
	@Test
	public void testAddFilmInfo(){
		FilmBean bf=new FilmBean("������", "10005", "��ķ��������", "ղķ˹����÷¡", 150.0);
		System.out.println(bf);
		int lfi=filmService.addFilmInfo(bf);
		System.out.println(lfi);
		assertEquals("����ɹ�",1,lfi);
	}

}
