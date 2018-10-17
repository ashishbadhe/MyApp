package com.app.util;

import java.io.IOException;
import java.io.InputStream;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Component
public class CommonUtil {
	@Autowired
	private JavaMailSender mailSender;
	
	public boolean sendEmail(String to, String text, String subject, final CommonsMultipartFile cmf){
		boolean flag = false;
		
		MimeMessage messege = mailSender.createMimeMessage();
		
		try {
			MimeMessageHelper helper = new MimeMessageHelper(messege, cmf!=null?true:false);
			helper.setTo(to);
			helper.setText(text);
			helper.setSubject(subject);
			helper.setFrom("ashishbadhe2018@gmail.com");
//			helper.setBcc(bcc);
//			helper.setCc(cc);
			if(cmf!=null){
				helper.addAttachment(cmf.getOriginalFilename(), new InputStreamSource() {
					
					@Override
					public InputStream getInputStream() throws IOException {
						return cmf.getInputStream();
					
					}
				});
			}
			mailSender.send(messege);
			flag=true;
		} catch (MessagingException e) {
			flag = false;
			e.printStackTrace();
		}
		
		
		return flag;
	}
	
	public boolean sendEmail(String to, String text, String subject){
		return sendEmail(to, text, subject, null);
	}
}
