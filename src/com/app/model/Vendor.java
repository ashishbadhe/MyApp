package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="ven_tab")
public class Vendor {
	@Id
	@GeneratedValue(generator="abc")
	@GenericGenerator(name="abc", strategy="com.app.generator.IdGenerator")
	@Column(name="ven_id")
	private int venId;
	@Column(name="ven_code")
	private String venCode;
	@Column(name="ven_name")
	private String venName;
	@Column(name="ven_type")
	private String venType;
	@Column(name="ven_addr")
	private String addr;
	@Column(name="ven_idtype")
	private String idType;
	@Column(name="ven_num")
	private String idNum;
	@Column(name="ven_note")
	private String dsc;
	
	public Vendor() {
	}

	public Vendor(int venId) {
		this.venId = venId;
	}

	public Vendor(int venId, String venCode, String venName, String venType,
			String addr, String idType, String idNum, String dsc) {
		this.venId = venId;
		this.venCode = venCode;
		this.venName = venName;
		this.venType = venType;
		this.addr = addr;
		this.idType = idType;
		this.idNum = idNum;
		this.dsc = dsc;
	}

	public int getVenId() {
		return venId;
	}

	public void setVenId(int venId) {
		this.venId = venId;
	}

	public String getVenCode() {
		return venCode;
	}

	public void setVenCode(String venCode) {
		this.venCode = venCode;
	}

	public String getVenName() {
		return venName;
	}

	public void setVenName(String venName) {
		this.venName = venName;
	}

	public String getVenType() {
		return venType;
	}

	public void setVenType(String venType) {
		this.venType = venType;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getIdNum() {
		return idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}

	public String getDsc() {
		return dsc;
	}

	public void setDsc(String dsc) {
		this.dsc = dsc;
	}

	@Override
	public String toString() {
		return "Vendor [venId=" + venId + ", venCode=" + venCode + ", venName="
				+ venName + ", venType=" + venType + ", addr=" + addr
				+ ", idType=" + idType + ", idNum=" + idNum + ", dsc=" + dsc
				+ "]";
	}
	
	
	
	
}
