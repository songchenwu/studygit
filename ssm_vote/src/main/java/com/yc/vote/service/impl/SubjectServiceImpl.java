package com.yc.vote.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yc.vote.entity.AddSubjectBean;
import com.yc.vote.entity.Option;
import com.yc.vote.mapper.SubjectMapper;
import com.yc.vote.service.SubjectService;

@Service("subjectService")
public class SubjectServiceImpl implements SubjectService {
	@Autowired
	private SubjectMapper subjectMapper;
	
	
	@Override @Transactional(propagation=Propagation.REQUIRED)
	public AddSubjectBean addSubject(AddSubjectBean addSubjectBean) {
		subjectMapper.insertSubject(addSubjectBean);
		return addSubjectBean;
	}

	@Override @Transactional(propagation=Propagation.REQUIRED)
	public void addOption(Option option) {
		subjectMapper.insertOption(option);
		
	}

	@Override @Transactional(propagation=Propagation.REQUIRED)
	public void add(AddSubjectBean addSubjectBean) {
		//1.插入主题subject
		addSubjectBean =addSubject(addSubjectBean);
		//插入所有的选项options
		List<String> options=addSubjectBean.getOptions();
		for (int i = 0; i < options.size(); i++) {
			Option option=new Option(options.get(i),i+1,addSubjectBean.getVsId());
			addOption(option);
		}
	}

	
	

	

}
