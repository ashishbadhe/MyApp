package com.app.service;

import java.util.List;

import com.app.model.Document;

public interface IDocumentService {
	public int saveDocument(Document doc);
	public void deleteDocument(int docId);
	public Document getDocumentById(int docId);
	public List<Object> getDocumentIdAndName();
}
