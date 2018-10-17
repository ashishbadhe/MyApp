package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IDocumentDao;
import com.app.model.Document;
import com.app.service.IDocumentService;
@Service
public class DocumentServiceImpl implements IDocumentService {
	@Autowired
	private IDocumentDao dao;
	
	
	@Override
	public int saveDocument(Document doc) {
		return dao.saveDocument(doc);
	}


	@Override
	public void deleteDocument(int docId) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Document getDocumentById(int docId) {
		// TODO Auto-generated method stub
		return dao.getDocumentById(docId);
	}


	@Override
	public List<Object> getDocumentIdAndName() {
		return dao.getDocumentIdAndName();
	}

	


}
