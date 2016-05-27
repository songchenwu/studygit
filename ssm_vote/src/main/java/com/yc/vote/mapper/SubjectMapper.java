package com.yc.vote.mapper;

import java.util.List;

import com.yc.vote.entity.AddSubjectBean;
import com.yc.vote.entity.Item;
import com.yc.vote.entity.Option;
import com.yc.vote.entity.OptionBean;
import com.yc.vote.entity.Subject;
import com.yc.vote.entity.SubjectBean;
import com.yc.vote.entity.VoteBean;

public interface SubjectMapper {

	List<Subject> getAllSubjects();

	List<SubjectBean> getAllSubjectsBeans();

	OptionBean getOptionsByVsId(int vsId);

	VoteBean getVoteBeanByVsId(int vsId);

	void insertItem(Item item);

	void insertSubject(AddSubjectBean addSubjectBean);

	void insertOption(Option options);
	
}