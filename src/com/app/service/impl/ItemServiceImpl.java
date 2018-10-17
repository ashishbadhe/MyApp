package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IItemDao;
import com.app.model.Item;
import com.app.service.IItemService;
@Service
public class ItemServiceImpl implements IItemService {
	@Autowired
	private IItemDao dao;
	
	
	@Override
	public int saveItem(Item item) {
		return dao.saveItem(item);
	}


	@Override
	public void deleteItem(int itemId) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Item getItemById(int itemId) {
		// TODO Auto-generated method stub
		return dao.getItemById(itemId);
	}


	@Override
	public List<Object> getItemIdAndName() {
		return dao.getItemIdAndName();
	}

	


}
