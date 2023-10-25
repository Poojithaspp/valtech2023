package com.valtech.training.day3;

import java.util.ArrayList;

import java.util.Collections;

import java.util.Comparator;

import java.util.List;


public class Employee implements Comparable<Employee>{
	private int seniority;
	private int experience;
	private String name;
	private int age;
	private int salary;	
	
	public Employee(int seniority,int experience,String name,int age,int salary)	{
		this.seniority =seniority;
		this.experience=experience;
		this.name=name;
		this.age=age;
		this.salary=salary;
	}
//	public int getSeniority()
//	{
public int compareTo(Employee o) {
		return this.name.compareTo(o.name);
//				+ (this.seniority.compareTo(o.seniority))
//                + (this.experience.compareTo(o.experience));
	}
//    public int compareToSeniority(Employee o1,Employee o2) {
//    	if (o1.seniority>o2.seniority) {
//    		return o1.seniority;
//    	}
//    	else {
//			return o2.seniority;
//		} }
    		
			
	
	@Override
	public String toString() {
	return "Employee [Seniority=" + seniority + " , Experience=" + experience + " , Name=" + name + " , Age=" + age + " , salary=" + salary + "]";
	}
    public static void main(String[] args) {
		List<Employee> employees = new  ArrayList<>();
		employees.add(new Employee(5,10,"Akansha",24,150000));
		employees.add(new Employee(8,12,"Poojitha",24,80000));
	    employees.add(new Employee(4,8,"Manjushree",24,60000));
	    employees.add(new Employee(2,5,"Gagana",24,50000));
	    System.out.println("Employee before sorting:");
	    for(Employee emp : employees)
	    {
	    	System.out.println(emp);
	    }
	    Collections.sort(employees);
	    System.out.println("\n Employees after sorting by name:");
	    for(Employee emp : employees)
	    {
	   	System.out.println(emp);
	    }
	}
//	@Override
//	public int compareTo(Employee o) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
