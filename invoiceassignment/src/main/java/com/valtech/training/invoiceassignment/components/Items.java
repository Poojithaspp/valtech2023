package com.valtech.training.invoiceassignment.components;

import org.springframework.stereotype.Component;

@Component
public class Items {
	private int itemId;
	private String itemDescription;
	private float unitPrice;
	private int compId;
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public float getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getCompId() {
		return compId;
	}
	public void setCompId(int compId) {
		this.compId = compId;
	}
	public Items(String itemDescription, float unitPrice,int compId) {
		this.itemDescription = itemDescription;
		this.unitPrice = unitPrice;
		this.compId= compId;
	}
	public Items() {
	
	}
	

}
