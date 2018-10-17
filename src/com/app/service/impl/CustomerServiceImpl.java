package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IVendorDao;
import com.app.model.Vendor;
import com.app.service.IVendorService;
@Service
public class CustomerServiceImpl implements IVendorService {
	@Autowired
	private IVendorDao dao;
	
	
	@Override
	public String saveVendor(Vendor ven) {
		return dao.saveVendor(ven);
	}

	@Override
	public void updateVendor(Vendor ven) {
		dao.updateVendor(ven);
	}

	@Override
	public void deleteVendor(String VenId) {
		dao.deleteVendor(VenId);
	}

	@Override
	public Vendor getVendorById(String venId) {
		return dao.getVendorById(venId);
	}

	@Override
	public List<Vendor> getAllVendors() {
		return dao.getAllVendors();
	}

	public List<Object[]> getVendorTypeCount() {
		
		return dao.getVendorTypeCount();
	}

}
