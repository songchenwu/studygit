package com.yc.vote.web.action;

import java.io.File;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.opensymphony.xwork2.ActionContext;

public class RegisterMailAction {
	private static final String MimeMessage = null;
	@Autowired
	private JavaMailSender javaMailSender;
	
	public String sendEmail(){

		MimeMessage mm=javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper smm=new MimeMessageHelper(mm,true);
			smm.setFrom("studymail_test@163.com");//�ʼ�������
			smm.setTo("918811028@qq.com");//�ʼ�������
			smm.setSubject("�����û�"); //�ʼ�����
			String activeId=UUID.randomUUID().toString();
			String activePath="http://localhost:8080/vote_ssm/user_active.action?activeId="+activeId;
			smm.setText("<html><body><a href='"+activePath+"'>"+activePath+"</a></body></html>", true); //�ʼ�����
		//	FileSystemResource res = new FileSystemResource(new File("d:/19.jpg"));
		//	smm.addInline("identifier1234", res);
			javaMailSender.send(mm);//�����ʼ�
			ActionContext.getContext().getSession().put("activeId", activeId);
			return "success";
		} catch (MessagingException e) {
		}
		return "fail";
		
	}
}
