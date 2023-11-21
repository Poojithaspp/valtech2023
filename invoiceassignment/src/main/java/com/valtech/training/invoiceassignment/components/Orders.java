package com.valtech.training.invoiceassignment.components;

import java.sql.Date;

public class Orders {
	private int  orderId;
	private String date;
	private int custId;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public Orders(String date,int custId) {
		super();
		this.date = date;
		this.custId=custId;
	}
	public Orders() {
		
	}
	
	

}
