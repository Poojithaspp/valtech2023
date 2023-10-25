package com.valtech.training.day3;

public class ThreadsTest {
	public static class PrinterThread extends Thread{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			for (int i = 0; i < 10; i++) {	
			System.out.println( Thread.currentThread()+""+i);
			}
		}
	}
	public static class PrinterThreadByInterface implements Runnable{
		public void run() {
			// TODO Auto-generated method stub
			for (int i = 0; i < 10; i++) {	
			System.out.println( Thread.currentThread()+""+i);
			}
	}
	}
public static void main(String[] args) {
	new PrinterThread().start();
	new PrinterThread().start();
	new Thread(new PrinterThreadByInterface()).start();
	
	new Thread(new Runnable() {
		public void run() {
			// TODO Auto-generated method stub
			for (int i = 0; i < 10; i++) {	
			System.out.println( Thread.currentThread()+""+i);
			}
		}
	}).start();
	for(int i=0;i<10;i++) {
		System.out.println(Thread.currentThread()+""+i);
	}

}} 

