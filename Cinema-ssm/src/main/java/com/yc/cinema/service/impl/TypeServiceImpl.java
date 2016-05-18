package com.yc.cinema.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.cinema.entity.FilmType;
import com.yc.cinema.mapper.FilmTypeMapper;
import com.yc.cinema.service.TypeService;
@Service("typeService")
public class TypeServiceImpl implements TypeService {
	@Autowired
	private FilmTypeMapper filmTypeMapper;
	
	
	@Override
	public List<FilmType> getTypes() {
		
		return filmTypeMapper.getAllFilmTypes();
	}

}
