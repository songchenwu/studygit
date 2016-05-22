package com.yc.fav.service;

import java.util.List;

import com.yc.fav.entity.Favorite;

public interface FavoriteService {
	List<Favorite> findAllFavorites();

	List<Favorite> findFavoriteByTagId(String tname);

	void addFavorite(Favorite favorite);
}
