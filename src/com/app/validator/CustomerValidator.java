package com.app.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.Customer;
import com.app.service.ICustomerService;
import com.app.util.CodecUtil;

@Component
public class CustomerValidator {
	@Autowired
	private ICustomerService service;
	@Autowired
	private CodecUtil codecUtil;
	
	public boolean isCustTypeSeller(Customer cust){
		return "SELLER".equalsIgnoreCase(cust.getCustType());
	}
	public boolean isCustTypeConsumer(Customer cust){
		return "CUNSUMER".equalsIgnoreCase(cust.getCustType());
	}
	
	public boolean isPwdAndTokenValid(String reqPassword, String reqToken, Customer cust){
		
		boolean flag = false;
		String encPwd = cust.getPassword();
		String encToken = cust.getAccToken();
		
		String dbpwd = codecUtil.doDecode(encPwd);
		String dbtoken = codecUtil.doDecode(encToken);
		
		if(reqPassword.equals(dbpwd) && reqToken.equals(dbtoken))
			flag=true;
		
		return flag;
		
	}
}
