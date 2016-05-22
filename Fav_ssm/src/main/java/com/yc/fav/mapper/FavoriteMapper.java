package com.yc.fav.mapper;

import java.util.List;

import com.yc.fav.entity.Favorite;

public interface FavoriteMapper {

  List<Favorite> getAllFavorites();

  List<Favorite> getFavoritesByTagId(String tname);

  void addFavorites(Favorite favorite);

}
	