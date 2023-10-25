package com.valtech.training.day1;

import java.io.Serializable;

public class Point implements Comparable<Point>,Serializable {
	//1.constants
	//2.static block
	//3. variables
	//4.constructors
	//5.Methods
	public static final Point ORIGIN = new Point();
	static {
	//	ORIGIN.x=1000;
	//	ORIGIN.y=2000;
		System.out.println(ORIGIN);
	}
	protected int x;
	protected int y;
	public Point() {
		System.out.println("point method");
	}
	public Point (int x,int y) {
		System.out.println("IN ctor of Point");
	//	super();
		this.x = x;
		this.y = y;
		
	}
	@Override
	public int compareTo (Point o) {
		
		return(x-o.x)== 0 ? (y-o.y):(x-o.x);
	}
	
@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Point p=(Point) obj;
		return p.x ==x&&p.y ==y;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return toString().hashCode();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "X=" + x+"Y=" +y+ "Distance=" +distance();
	}
	public double distance(Point other) {
		System.out.println("distance with another point ");
		return distance (other.x,other.y);
	}
	public double distance (int x, int y) {
		int diffx=this.x-x;
		int diffy=this.y-y;
		return Math.sqrt(diffx*diffx + diffy*diffy);
		
	}
	
	
	public double distance() {
		System.out.println("distance in point");
		int diffx =x -ORIGIN.x;
		int diffy =y -ORIGIN.y;
		return Math.sqrt(diffx*diffx + diffy*diffy);
	}
	public static void main(String[] args) {
		Point p = new Point();
		p.x =10;
		p.y =20;
	//	System.out.println(p.distance());
		//ORIGIN.x =10;
		//System.out.println(p.distance());
		//Point p1 =new Point();
		//System.out.println(p1.distance());
		System.out.println(p);
	}

}
