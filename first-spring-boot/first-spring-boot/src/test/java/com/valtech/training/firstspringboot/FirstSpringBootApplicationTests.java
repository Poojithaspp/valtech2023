package com.valtech.training.firstspringboot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.training.firstspringboot.components.DivideByZeroException;
import com.valtech.training.firstspringboot.components.Employee;
import com.valtech.training.firstspringboot.components.EmployeeDAOImpl;
import com.valtech.training.firstspringboot.components.HelloWorld;
import com.valtech.training.firstspringboot.components.SimpleInterest;
import com.valtech.training.firstspringboot.entity.Order;
import com.valtech.training.firstspringboot.repositories.OrderRepo;
import com.valtech.training.firstspringboot.service.OrderService;
 
@SpringBootTest
class FirstSpringBootApplicationTests {
	@Autowired
	private HelloWorld helloWorld;
	@Autowired
	private EmployeeDAOImpl employeeDAOimpl;
	@Autowired
	private OrderService orderService;
	@Autowired
	private SimpleInterest simpleInterest;
	
	@Test
	void testSI() throws DivideByZeroException {
		simpleInterest.computeInterest(20000, 3, 3);
	}
	
	@Test
	void testOrder() {
		Order o = orderService
				.createOrder(new Order("Macbook pro M3", 25, "for the entire team", LocalDate.of(2023, 11, 8)));
	assertEquals(4, o.getId());
	assertTrue(orderService.getAllOrders().size()>0);
	}
	
	@Test
	void testEmployeeDAO(){
		assertEquals(4,employeeDAOimpl.count());
		assertEquals(4,employeeDAOimpl.getAllEmployees().size());
		
	}
 
	@Test
	void contextLoads() {
		assertNotNull(helloWorld);
		assertEquals("Hello Spring Boot",helloWorld.hello());
	
	}
 
}