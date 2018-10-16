package com.app.service;

import java.util.List;

import com.app.model.Vendor;

public interface IVendorService {
	public String saveVendor(Vendor ven);
	public void updateVendor(Vendor ven);
	public void deleteVendor(String VenId);
	public Vendor getVendorById(String venId);
	public List<Vendor> getAllVendors();
	
	public List<Object[]> getVendorTypeCount();
}
