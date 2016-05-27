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
		SimpleMailMessage smm=new SimpleMailMessage();//�ʼ���Ϣ��
		smm.setFrom("studymail_test@163.com");//�ʼ�������
		smm.setTo("918811028@qq.com");//�ʼ�������
		smm.setSubject("spring�ʼ����ϲ���"); //�ʼ�����
		smm.setText("spring�ʼ���������������"); //�ʼ�����
		
		javaMailSender.send(smm);//�����ʼ�
		System.out.println("�ʼ����ͳɹ�");
	}

	
	@Test
	public void testSendEMail02() {
		MimeMessage mm=javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper smm=new MimeMessageHelper(mm,true);
			smm.setFrom("studymail_test@163.com");//�ʼ�������
			smm.setTo("918811028@qq.com");//�ʼ�������
			smm.setSubject("spring�ʼ����ϲ���5"); //�ʼ�����
			smm.setText("<html><body><img src='cid:identifier1234'></body></html>", true); //�ʼ�����
			
			FileSystemResource res = new FileSystemResource(new File("d:/19.jpg"));
			smm.addInline("identifier1234", res);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		javaMailSender.send(mm);//�����ʼ�
		System.out.println("�ʼ����ͳɹ�03");
	}
}
