package com.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.app.model.Document;
import com.app.service.IDocumentService;

@Controller
public class DocumentController {
	@Autowired
	private IDocumentService service;
	
	@RequestMapping("/showDocs")
	public String showDoc(ModelMap map){
		List<Object> obs = service.getDocumentIdAndName();
		map.addAttribute("docs", obs);
		return "Documents";
	}
	
	@RequestMapping(value="/uploadDocs", method=RequestMethod.POST)
	public String uploadDocument(@RequestParam("fileId")int fileId, @RequestParam("fileOb")CommonsMultipartFile cmf){
		if(cmf!=null){
			Document doc = new Document();
			doc.setFileId(fileId);
			doc.setFileName(cmf.getOriginalFilename());
			doc.setFileData(cmf.getBytes());
			service.saveDocument(doc);
		}
		return "redirect:showdocs";
	}
	
	public void downloadDocument(@RequestParam("fileId")int docId, HttpServletResponse res){
		Document doc = service.getDocumentById(docId);
		
		res.addHeader("Content-Disposition", "attachment;filename="+doc.getFileName());
		
		try {
			FileCopyUtils.copy(doc.getFileData(), res.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
