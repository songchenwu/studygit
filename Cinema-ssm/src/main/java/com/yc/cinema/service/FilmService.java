package com.yc.cinema.service;

import java.util.List;

import com.yc.cinema.entity.FilmBean;
import com.yc.cinema.entity.FilmInfo;

public interface FilmService {

	List<FilmInfo> getFilmsByBean(FilmBean filmBean);

	int addFilmInfo(FilmBean filmBean);


}
