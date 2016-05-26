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
	private TagMapper tagMapper; //ȡ���ݵ�ӳ��ӿ�
	
	@Override
	public List<Tag> findAllTags() {
		return tagMapper.getAllTags();
	}

	@Override @Transactional(propagation=Propagation.REQUIRED)
	public void addTags(String tname) {
		//��ѯ
		//tagMapper.findTags(tname);
		//���tag�Ѵ��ڣ�����+1
		if(tagMapper.findTags(tname)!=null){
			tagMapper.updateCount();//����+1
		}else{
			//���tag�����ڣ��½�tag
			tagMapper.insertTag(tname);
		}
		
	}
}
