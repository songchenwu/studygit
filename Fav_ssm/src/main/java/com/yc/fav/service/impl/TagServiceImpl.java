package com.yc.fav.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yc.fav.entity.Tag;
import com.yc.fav.mapper.TagMapper;
import com.yc.fav.service.TagService;
@Transactional(propagation=Propagation.REQUIRED)
@Service("tagService")
public class TagServiceImpl implements TagService{
	@Autowired
	private TagMapper tagMapper; //取数据的映射接口
	
	@Override
	public List<Tag> findAllTags() {
		return tagMapper.getAllTags();
	}

	@Override @Transactional(propagation=Propagation.REQUIRED)
	public void addTags(String tname) {
		//查询
		//tagMapper.findTags(tname);
		//如果tag已存在，数量+1
		if(tagMapper.findTags(tname)!=null){
			tagMapper.updateCount();//数量+1
		}else{
			//如果tag不存在，新建tag
			tagMapper.insertTag(tname);
		}
		
	}
}
