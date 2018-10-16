package com.app.views;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Vendor;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class VendorPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> map, Document doc,
			PdfWriter pw, HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		
		res.addHeader("Content-Disposition", "attachment;filename=Vendors.pdf");
		
		List<Vendor> venOb = (List<Vendor>) map.get("venOb");
		
		Paragraph p = new Paragraph("Welcome to vendors Data");
		
		PdfPTable t= new PdfPTable(8);
		t.addCell("ID");
		t.addCell("NAME");
		t.addCell("CODE");
		t.addCell("TYPE");
		t.addCell("ADDRESS");
		t.addCell("ID TYPE");
		t.addCell("ID NUM");
		t.addCell("NOTE");
		
		for(Vendor venObj:venOb){
			t.addCell(venObj.getVenId());
			t.addCell(venObj.getVenName());
			t.addCell(venObj.getVenCode());
			t.addCell(venObj.getVenType());
			t.addCell(venObj.getAddr());
			t.addCell(venObj.getIdType());
			t.addCell(venObj.getIdNum());
			t.addCell(venObj.getDsc());
			
		}
		
		doc.add(p);
		doc.add(t);
		doc.add(new Paragraph(new Date().toString()));
	}

}
