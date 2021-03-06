package com.app.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Vendor;
import com.app.service.IVendorService;
import com.app.util.VendorUtil;

@Controller
public class VendorController {
	@Autowired
	private IVendorService service;
	@Autowired
	private VendorUtil vendorUtil;
	@Autowired
	private ServletContext context;
	
	@RequestMapping("/venReg")
	public String showRegPage(){
		return "VendorReg";
	}
	
	@RequestMapping(value="/insertVen", method=RequestMethod.POST)
	public String saveVendor(@ModelAttribute("vendor")Vendor ven, ModelMap map){
		String message=null;
		
		if(ven!=null){
			String id = service.saveVendor(ven);
			message = "Vendor Saved successfully"+id;
		}
		else
			message = "Vendor info is inavalid.";
		map.addAttribute("msg", message);
		return "VendorReg";
	}
	
	@RequestMapping("/viewAllVendors")
	public String showAllVendors(ModelMap map){
		List<Vendor> list = service.getAllVendors();
		map.addAttribute("venOb", list);
		return "VendorData";
	}
	
	@RequestMapping("/deleteVen")
	public String deleteVendor(@RequestParam("venId")String venId, ModelMap map){
		service.deleteVendor(venId);
		return "redirect:viewAllVendors";
	}
	
	@RequestMapping("/editVen")
	public String editVendor(@RequestParam("venId")String venId, ModelMap map){
		Vendor ven = service.getVendorById(venId);
		map.addAttribute("ven", ven);
		vendorUtil.addUiComponent(map);
		return "VendorEditData";
	}
	
	@RequestMapping(value="/updateVen", method=RequestMethod.POST)
	public String updateVendor(@ModelAttribute("vendor")Vendor ven){
		service.updateVendor(ven);
		return "redirect:viewAllVendors";
	}
	
	@RequestMapping("/excelExport")
	public String exportDataInExcel(ModelMap map){
		List<Vendor> venOb = service.getAllVendors();
		map.addAttribute("venOb", venOb);
		return "vendorExcelView";
	}
	
	@RequestMapping("/pdfExport")
	public String exportDataInPdf(ModelMap map){
		List<Vendor> ven = service.getAllVendors();
		map.addAttribute("venOb", ven);
		return "vendorPdfView";
	}
	
	@RequestMapping("/genReport")
	public String generateReports(ModelMap map){
		List<Object[]> venObj = service.getVendorTypeCount();
		String path = context.getRealPath("/");
		vendorUtil.generatePieChart(path, venObj);
		vendorUtil.generateBarChart(path, venObj);
		return "VendorReports";
	}
	
	
	
	
}
