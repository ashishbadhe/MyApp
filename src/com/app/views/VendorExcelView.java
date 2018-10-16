package com.app.views;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.app.model.Vendor;
@Component
public class VendorExcelView extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> map,
			HSSFWorkbook book, HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		res.addHeader("Content-Disposition", "attachment;filename=Vendor.xls");
		
		List<Vendor> venOblist = (List<Vendor>) map.get("venOb");
		
		HSSFSheet sheet = book.createSheet("Vendors Data");
		
		setHead(sheet);
		setBody(sheet,venOblist);

	}

	private void setHead(HSSFSheet sheet) {
		int rownum=0;
		HSSFRow row = sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("NAME");
		row.createCell(2).setCellValue("CODE");
		row.createCell(3).setCellValue("TYPE");
		row.createCell(4).setCellValue("ADDRESS");
		row.createCell(5).setCellValue("ID PROOF");
		row.createCell(6).setCellValue("ID NUMBER");
		row.createCell(7).setCellValue("NOTE");
		
	}

	private void setBody(HSSFSheet sheet, List<Vendor> venOblist) {
		int rownum=1;
		for(Vendor venOb:venOblist){
		HSSFRow row = sheet.createRow(rownum++);
		row.createCell(0).setCellValue(venOb.getVenId());
		row.createCell(1).setCellValue(venOb.getVenName());
		row.createCell(2).setCellValue(venOb.getVenCode());
		row.createCell(3).setCellValue(venOb.getVenType());
		row.createCell(4).setCellValue(venOb.getAddr());
		row.createCell(5).setCellValue(venOb.getIdType());
		row.createCell(6).setCellValue(venOb.getIdNum());
		row.createCell(7).setCellValue(venOb.getDsc());
		}
	}

}
