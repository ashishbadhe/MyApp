package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.model.Customer;
import com.app.service.ICustomerService;
import com.app.util.CodeUtil;
import com.app.util.CodecUtil;
import com.app.util.CommonUtil;

@Controller
public class CustomerController {
	@Autowired
	private ICustomerService service;
	@Autowired
	private CommonUtil commonUtil;
	@Autowired
	private CodeUtil codeUtil;
	@Autowired
	private CodecUtil codecUtil;
	
	@RequestMapping(value="/insertCustomer", method=RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("customer")Customer cust, ModelMap map){
		String token = codeUtil.generateToken();
		String password = codeUtil.generatePassword();
		
		String encPasssword = codecUtil.doEncode(password);
		String encToken = codecUtil.doEncode(token);
		
		cust.setAccToken(encToken);
		cust.setPassword(encPasssword);
		
		String id = service.saveCustomer(cust);
		String message = "Customer saved successfully with Id"+id;
		
		boolean flag = commonUtil.sendEmail(cust.getCustEmail(), "Welcome to VDMS, Dear Customer "+cust.getCustName()+" \n Your ID: "+cust.getCustEmail()+" \n password: "+password+" \n Token: "+token+"\n Plaese go to Login Page And Login.", "Customer Login Details");
		if(!flag)
			message+= "Email Not Sent to customer";
		else
			message+="Email also sent to customer.";
		
		map.addAttribute("msg", message);
		
		return "CustomerReg";
	}
}
