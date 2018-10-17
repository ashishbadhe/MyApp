package com.app.util;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class CodeUtil {
	public String generateString(int len){
		String s = UUID.randomUUID().toString().replaceAll("-", "").substring(0, len);
		return s;
	}
	
	public String generatePassword(){
		return generateString(6);
	}
	public String generateToken(){
		return generateString(4);
	}
}
