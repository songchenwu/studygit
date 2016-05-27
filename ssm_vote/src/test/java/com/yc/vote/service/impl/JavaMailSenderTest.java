package com.yc.vote.service.impl;


import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class JavaMailSenderTest {
	@Autowired
	private JavaMailSender javaMailSender;
	@Test
	public void testSendEMail() {
		SimpleMailMessage smm=new SimpleMailMessage();//邮件信息类
		smm.setFrom("studymail_test@163.com");//邮件发送者
		smm.setTo("918811028@qq.com");//邮件接收者
		smm.setSubject("spring邮件整合测试"); //邮件主题
		smm.setText("spring邮件发送啦啦啦啦啦"); //邮件内容
		
		javaMailSender.send(smm);//发送邮件
		System.out.println("邮件发送成功");
	}

	
	@Test
	public void testSendEMail02() {
		MimeMessage mm=javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper smm=new MimeMessageHelper(mm,true);
			smm.setFrom("studymail_test@163.com");//邮件发送者
			smm.setTo("918811028@qq.com");//邮件接收者
			smm.setSubject("spring邮件整合测试5"); //邮件主题
			smm.setText("<html><body><img src='cid:identifier1234'></body></html>", true); //邮件内容
			
			FileSystemResource res = new FileSystemResource(new File("d:/19.jpg"));
			smm.addInline("identifier1234", res);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		javaMailSender.send(mm);//发送邮件
		System.out.println("邮件发送成功03");
	}
}
