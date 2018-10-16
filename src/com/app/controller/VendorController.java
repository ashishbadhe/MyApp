package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.app.model.Vendor;
import com.app.service.IVendorService;

@Controller
public class VendorController {
	@Autowired
	private IVendorService service;
	
	@RenderMapping("/venReg")
	public String showRegPage(){
		return "VendorReg";
	}
	
	@RequestMapping(value="/insertVen", method=RequestMethod.POST)
	public String saveVendor(@ModelAttribute("vendor")Vendor ven, ModelMap map){
		String message=null;
		
		if(ven!=null){
			String id = service.saveVendor(ven);
			message = "Vendor Saved successfully"+id;
		}
		else
			message = "Vendor info is inavalid.";
		map.addAttribute("msg", message);
		return "VendorReg";
	}
	
	
}
