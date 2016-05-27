package com.yc.vote.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.vote.entity.OptionBean;
import com.yc.vote.entity.Subject;
import com.yc.vote.entity.SubjectBean;
import com.yc.vote.entity.VoteBean;
import com.yc.vote.service.VoteService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class VoteServiceImplTest {
	@Autowired
	private VoteService voteService;
	@Test
	public void testFindAllSubjects() {
		List<Subject> subjects=voteService.findAllSubjects();
		System.out.println(subjects);
		assertNotNull(subjects);
	}
	
	@Test
	public void testFindAllSubjectsBean() {
		List<SubjectBean> subjects=voteService.findAllSubjectsBeans();
		System.out.println(subjects);
		assertNotNull(subjects);
	}
	
	@Test
	public void testFindOptionsById() {
		OptionBean subjectBean=voteService.findOptionsByVsId(103);
		System.out.println(subjectBean);
		assertNotNull(subjectBean);
	}
	
	@Test
	public void testfindVoteBeanByVsId() {
		VoteBean voteBean=voteService.findVoteBeanByVsId(102);
		System.out.println(voteBean);
		assertNotNull(voteBean);
	}
	
	

}
