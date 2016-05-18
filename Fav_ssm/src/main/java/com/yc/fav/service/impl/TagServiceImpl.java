package com.yc.fav.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.fav.entity.Tag;
import com.yc.fav.mapper.TagMapper;
import com.yc.fav.service.TagService;
@Service("tagService")
public class TagServiceImpl implements TagService{
	@Autowired
	private TagMapper tagMapper; //ȡ���ݵ�ӳ��ӿ�
	
	@Override
	public List<Tag> findAllTags() {
		return tagMapper.getAllTags();
	}

}
