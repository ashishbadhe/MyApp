package com.app.util;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

@Component
public class VendorUtil {
	public List<String> getVenType(){
		return Arrays.asList("CONTRACT","FULLTIME","PARTTIME");
	}
	public List<String> getVenId(){
		return Arrays.asList("PAN", "AADHAR", "VOTERID");
	}
	
	public void addUiComponent(ModelMap map){
		map.addAttribute("venType", getVenType());
		map.addAttribute("venIdType", getVenId());
		
	}
}
