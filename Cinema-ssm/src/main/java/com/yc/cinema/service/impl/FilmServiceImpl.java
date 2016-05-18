package com.yc.cinema.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.cinema.entity.FilmBean;
import com.yc.cinema.entity.FilmInfo;
import com.yc.cinema.mapper.FilmInfoMapper;
import com.yc.cinema.service.FilmService;
@Service("filmService")
public class FilmServiceImpl implements FilmService {
	@Autowired
	private FilmInfoMapper filmInfoMapper;
	
	
	@Override
	public List<FilmInfo> getFilmsByBean(FilmBean filmBean) {
		return filmInfoMapper.getFilmsByBean(filmBean);
	}
	@Override
	public int addFilmInfo(FilmBean filmBean) {
		return filmInfoMapper.addFilmInfo(filmBean);
	}
}
