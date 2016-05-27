package com.yc.vote.service;

import java.util.List;

import com.yc.vote.entity.AddSubjectBean;
import com.yc.vote.entity.Option;
import com.yc.vote.entity.Subject;

public interface SubjectService {
	AddSubjectBean addSubject(AddSubjectBean addSubjectBean);
	void addOption(Option options);
	void add(AddSubjectBean addSubjectBean);

}
