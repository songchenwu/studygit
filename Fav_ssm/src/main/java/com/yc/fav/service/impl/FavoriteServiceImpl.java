package com.yc.fav.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.fav.entity.Favorite;
import com.yc.fav.mapper.FavoriteMapper;
import com.yc.fav.service.FavoriteService;
@Service("favoriteService")
public class FavoriteServiceImpl implements FavoriteService{
	@Autowired
	private FavoriteMapper favoriteMapper;
	
	@Override
	public List<Favorite> findAllFavorites() {
		return favoriteMapper.getAllFavorites();
	}

	@Override
	public List<Favorite> findFavoriteByTagId(String tname) {
		tname = "%" + tname + "%";
		return favoriteMapper.getFavoritesByTagId(tname);
	}

	@Override
	public void addFavorite(Favorite favorite) {
		try {
			favoriteMapper.addFavorites(favorite);
		} catch (Exception e) {
			new RuntimeException("≤Â»Î ß∞‹",e);
		}
		
	}
	
}
