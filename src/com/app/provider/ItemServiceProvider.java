package com.app.provider;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.Customer;
import com.app.model.Item;
import com.app.service.ICustomerService;
import com.app.service.IItemService;
import com.app.util.JsonUtil;
import com.app.validator.CustomerValidator;

@Component
@Path("/item")
public class ItemServiceProvider {
	@Autowired
	private ICustomerService customerService;
	@Autowired
	private JsonUtil jsonUtil;
	@Autowired
	private IItemService iItemService;
	@Autowired
	private CustomerValidator validator;
	
	@POST
	@Path("/save")
	public String saveitem(
			@HeaderParam("user")String userName,
			@HeaderParam("password")String password,
			@HeaderParam("token")String token,
			String json){
		
		if(userName==null && "".equals(userName.trim()))
			return "please provide username";
		if(password==null && "".equals(password.trim()))
			return "please provide password";
		if(token==null && "".equals(token.trim()))
			return "please provide token";
		if(json==null && "".equals(json.trim()))
			return "please provide json";
		
		Customer cust = customerService.getCustomerByEmail(userName);
		if(cust==null)
			return "Invalid username proviede";
		
		boolean flag = validator.isPwdAndTokenValid(password, token, cust);
		if(!flag)
			return "Invalid token and password";
		
		flag= validator.isCustTypeSeller(cust);
		if(!flag)
			return "Only Seller Allowed";
		
		Object ob = jsonUtil.convertJsonToObject(json, Item.class);
		if(ob==null)
			return "Invalid Json String";
		
		Item item = null;
		if(ob instanceof Item)
			item = (Item) ob;
		
		item.setCustId(Integer.parseInt(cust.getCustId()));
		
		int id = iItemService.saveItem(item);
		String message = "Item successfully saved with id "+id;
		return message;
	}
}
