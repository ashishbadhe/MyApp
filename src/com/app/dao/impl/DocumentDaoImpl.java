package com.app.dao.impl;

import java.util.List;

import org.apache.catalina.ant.FindLeaksTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.ICustomerDao;
import com.app.dao.IDocumentDao;
import com.app.model.Customer;
import com.app.model.Document;
@Repository
public class DocumentDaoImpl implements IDocumentDao {
	@Autowired
	private HibernateTemplate ht;

	@Override
	public int saveDocument(Document doc) {
		return (Integer) ht.save(doc);
	}

	@Override
	public void deleteDocument(int docId) {
		
	}

	@Override
	public Document getDocumentById(int fileId) {
		return ht.get(Document.class, fileId);
	}

	
	public List<Object> getDocumentIdAndName() {
		String hql = "select fileId, fileName from "+Document.class.getName();
		List<Object> obs = ht.find(hql);
		return obs;
	}
	
	
}
