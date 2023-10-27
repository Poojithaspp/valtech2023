package com.valtech.training.day1;

import com.valtech.training.week2.Adder;
import com.valtech.training.week2.AdderImpl;

public class StringTest {

	public static void main(String[] args) {
		Adder a=new AdderImpl();
		System.out.println(a.add(2, 3));
		Adder a1=new Adder() {
	
			@Override
			public int add(int a, int b) {
				// TODO Auto-generated method stub
				return a+b;
			}
			
		};
		//lamda expressions
		Adder a2=(i,j) ->{return i+j;};
		System.out.println(a2.add(3, 4));
	}

}
