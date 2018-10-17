package com.app.dao;

import java.util.List;

import com.app.model.Item;

public interface IItemDao {
	public int saveItem(Item item);
	public void deleteItem(int itemId);
	public Item getItemById(int itemId);
	public List<Object> getItemIdAndName();
	
}
