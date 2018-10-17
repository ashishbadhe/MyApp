package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cust_tab")
public class Customer {
	@Id
	@GeneratedValue
	@Column(name="cust_id")
	private String custId;
	@Column(name="cust_name")
	private String custName;
	@Column(name="cust_email")
	private String custEmail;
	@Column(name="cust_type")
	private String custType;
	@Column(name="cust_addr")
	private String custAddr;
	@Column(name="cust_password")
	private String password;
	@Column(name="cust_token")
	private String accToken;
	
	public Customer() {
		super();
	}

	public Customer(String custId) {
		super();
		this.custId = custId;
	}

	public Customer(String custId, String custName, String custEmail,
			String custType, String custAddr, String password, String accToken) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custEmail = custEmail;
		this.custType = custType;
		this.custAddr = custAddr;
		this.password = password;
		this.accToken = accToken;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public String getCustType() {
		return custType;
	}

	public void setCustType(String custType) {
		this.custType = custType;
	}

	public String getCustAddr() {
		return custAddr;
	}

	public void setCustAddr(String custAddr) {
		this.custAddr = custAddr;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccToken() {
		return accToken;
	}

	public void setAccToken(String accToken) {
		this.accToken = accToken;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName
				+ ", custEmail=" + custEmail + ", custType=" + custType
				+ ", custAddr=" + custAddr + ", password=" + password
				+ ", accToken=" + accToken + "]";
	}
	
	
}
