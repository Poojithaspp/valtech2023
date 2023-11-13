package com.valtech.training.orders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.training.orders.components.HelloWorld;

@SpringBootTest
class OrdersApplicationTests {
	@Autowired
	private HelloWorld helloWorld;


	@Test
	void contextLoads() {
		assertNotNull(helloWorld);
		assertEquals("Hello Spring Boot",helloWorld.hello());
	
	}
 
}
