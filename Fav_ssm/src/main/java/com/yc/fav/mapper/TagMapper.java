package com.yc.fav.mapper;

import java.util.List;

import com.yc.fav.entity.Tag;

public interface TagMapper {

	List<Tag> getAllTags();

	void insertTag(String tname);

	Tag findTags(String tname);
	
	Tag updateCount();
}
