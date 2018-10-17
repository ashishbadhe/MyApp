package com.app.dao.impl;

import java.util.List;

import org.apache.catalina.ant.FindLeaksTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.ICustomerDao;
import com.app.model.Customer;
@Repository
public class CustomerDaoImpl implements ICustomerDao {
	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public String saveCustomer(Customer cust) {
		return (String) ht.save(cust);
	}

	@Override
	public void updateCustomer(Customer cust) {
		ht.update(cust);
	}

	@Override
	public void deleteCustomer(String custId) {
		ht.delete(new Customer(custId));
	}

	@Override
	public Customer getCustomerById(String custId) {
		Customer cust = ht.get(Customer.class, custId);
		
		return cust;
	}

	@Override
	public List<Customer> getAllCustomers() {
		return ht.loadAll(Customer.class);
	}


	public List<Object[]> getCustomerTypeCount() {
		
		String hql = "select custType, count(custType) from "+Customer.class.getName()+" group by custType";
		List<Object[]> custObj = ht.find(hql);
		return custObj;
	}

	
	public Customer getCustomerByEmail(String email) {
		Customer cust = null;
		String hql = "from "+Customer.class.getName()+" where cuustEmail=? ";
		List<Customer> custList = ht.find(hql, email);
		if(custList!=null && custList.size()>0){
			cust=custList.get(0);
		}
		return cust;
	}

}
