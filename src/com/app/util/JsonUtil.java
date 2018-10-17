package com.app.util;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class JsonUtil {
	public Object convertJsonToObject(String json, Class<?> clz){
		Object obj=null;
		ObjectMapper om = new ObjectMapper();
		try {
			obj = om.readValue(json, clz);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
	
	public String convertObjectToJson(Object obj){
		String json=null;
		ObjectMapper om = new ObjectMapper();
		try {
			json = om.writeValueAsString(obj);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}
}
