package com.valtech.training.week2;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class DataSample {
	public static void main(String[] args) {
		Date date = new Date(47, 7, 15);
		System.out.println(date);
		LocalDate independenceDay = LocalDate.of(1947, 8, 15);
		// LocalTime independenceDay =LocalTime.of(4,50);
		System.out.println(independenceDay);
	}

}
