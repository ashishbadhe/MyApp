package com.app.dao.impl;

import java.util.List;

import org.apache.catalina.ant.FindLeaksTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.ICustomerDao;
import com.app.dao.IItemDao;
import com.app.model.Customer;
import com.app.model.Item;
@Repository
public class ItemDaoImpl implements IItemDao {
	@Autowired
	private HibernateTemplate ht;

	@Override
	public int saveItem(Item item) {
		return (Integer) ht.save(item);
	}

	@Override
	public void deleteItem(int itemId) {
		
	}

	@Override
	public Item getItemById(int fileId) {
		return ht.get(Item.class, fileId);
	}

	
	public List<Object> getItemIdAndName() {
		String hql = "select fileId, fileName from "+Item.class.getName();
		List<Object> obs = ht.find(hql);
		return obs;
	}
	
	
}
