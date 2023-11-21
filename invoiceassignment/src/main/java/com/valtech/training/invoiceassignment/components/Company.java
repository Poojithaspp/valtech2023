package com.valtech.training.invoiceassignment.components;

public class Company {
	private int compId;
	private String compName;
	private String address;
	
	public Company() {
	
	}
	public Company(String compName, String address) {
		super();
		this.compName = compName;
		this.address = address;
	}
	public int getCompId() {
		return compId;
	}
	public void setCompId(int compId) {
		this.compId = compId;
	}
	public String getCompName() {
		return compName;
	}
	public void setCompName(String compName) {
		this.compName = compName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	

}
