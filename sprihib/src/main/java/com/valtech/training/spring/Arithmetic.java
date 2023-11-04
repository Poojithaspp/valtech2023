package com.valtech.training.spring;

public interface Arithmetic {
	int zero =0;
	//constant should be well defined at the declaration
	int add(int a,int b); //methods
	int sub(int a,int b);
	int mul(int a,int b);
	int div(int a, int b) throws DivideByZeroException ;

}
