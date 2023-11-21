package com.valtech.training.invoiceassignment.components;


public class Customer {
	private int custId;
	private String custName;
	private String custAddress;
	private int phonenumber;
	
	public Customer() {
	}

	public Customer(String custName, String custAddress, int phonenumber) {
		super();
		this.custName = custName;
		this.custAddress = custAddress;
		this.phonenumber = phonenumber;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public int getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custAddress=" + custAddress + ", phonenumber="
				+ phonenumber + "]";
	}
	
	

}
