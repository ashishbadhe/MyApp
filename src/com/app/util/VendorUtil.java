package com.app.util;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

@Component
public class VendorUtil {
	public List<String> getVenType(){
		return Arrays.asList("CONTRACT","FULLTIME","PARTTIME");
	}
	public List<String> getVenId(){
		return Arrays.asList("PAN", "AADHAR", "VOTERID");
	}
	
	public void addUiComponent(ModelMap map){
		map.addAttribute("venType", getVenType());
		map.addAttribute("venIdType", getVenId());
		
	}
	
	public void generatePieChart(String path,List<Object[]> venObj){
		
		DefaultPieDataset dataset = new DefaultPieDataset();
		
		for(Object[] ob:venObj){
			dataset.setValue(ob[0].toString(), new Double(ob[1].toString()));
		}
		JFreeChart chart = ChartFactory.createPieChart3D("Vendor Data", dataset, true, true, null);
		
		try {
			ChartUtilities.saveChartAsJPEG(new File(path+"/VendorPie.jpg"), chart, 300, 300);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void generateBarChart(String path, List<Object[]> venObj){
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		for(Object[] ob:venObj){
			dataset.setValue(new Double(ob[1].toString()),ob[0].toString(), "");
		}
		
		JFreeChart chart = ChartFactory.createBarChart3D("Vendor Data", "Vendor Type", "COUNT", dataset, null, true	, true, false);
		
		try {
			ChartUtilities.saveChartAsJPEG(new File(path+"/VendorBar.jpg"), chart, 300, 300);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}
}
