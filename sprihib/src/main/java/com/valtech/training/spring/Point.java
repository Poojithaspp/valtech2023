package com.valtech.training.spring;

public class Point {
	private int x;
	private int y;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Point() {
	}
	public Point(int x, int y) {
		System.out.println("Parametered ctor.....");
		this.x = x;
		this.y = y;
	}
	
	
	

}
