package com.valtech.training.invoiceassignment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.training.invoiceassignment.components.Company;
import com.valtech.training.invoiceassignment.components.CompanyDAOImpl;
import com.valtech.training.invoiceassignment.components.Customer;
import com.valtech.training.invoiceassignment.components.CustomerDAOImpl;
import com.valtech.training.invoiceassignment.components.Items;
import com.valtech.training.invoiceassignment.components.ItemsDAO;
import com.valtech.training.invoiceassignment.components.ItemsDAOImpl;
import com.valtech.training.invoiceassignment.components.Orders;
import com.valtech.training.invoiceassignment.components.OrdersDAOImpl;

@SpringBootTest
class InvoiceassignmentApplicationTests {
	@Autowired
	private CustomerDAOImpl customerDAOimpl;
	@Autowired
	private CompanyDAOImpl companyDAOImpl;
	@Autowired
	private OrdersDAOImpl ordersDAOImpl;
	@Autowired
	private ItemsDAOImpl itemDAOImpl;

	
	

	@Test
	void testCustomerDAO() {
//		Customer customer=new Customer("Raksha","Banglore",900087893);
//		customerDAOimpl.createCustomer(customer);

		customerDAOimpl.deleteCustomer(4);

		assertEquals(3, customerDAOimpl.count());
		assertEquals(3, customerDAOimpl.getAllCustomers().size());

	}

	@Test
	void testCompanyDAO() {
//	Company company=new Company("IBM","Banglore");
//	companyDAOImpl.createCompany(company);		
		assertEquals(2, companyDAOImpl.count());
		
		Company company = new Company();
//		companyDAOImpl.updateCompany(company);
//		company.setCompId(4);
//		company.setCompName("TCS");
//		company.setAddress("Banglore");

//		companyDAOImpl.deleteCompany(3);

	}

	@Test
	void testOrdersDAO() {
		assertEquals(3, ordersDAOImpl.count());
     	ordersDAOImpl.deleteOrder(3);
//		Orders orders = new Orders("2023-08-15", 3);
//		ordersDAOImpl.createOrder(orders);
	
		}
	@Test
	void testItemDAO() {
		
		assertEquals(5,itemDAOImpl.count());
	//Items item= new Items("Iphone15pro",80000,4);
//	itemDAOImpl.createItem(item);
	//itemDAOImpl.deleteItem(6);
//	 Items existingItem = itemDAOImpl.getItems(1);
//         existingItem.setItemDescription("HP Laptop");
//         existingItem.setUnitPrice(70000);
//         existingItem.setCompId(4);
//         itemDAOImpl.updateItem(existingItem);
//         Items updatedItem = itemDAOImpl.getItems(existingItem.getItemId());
//         assertNotNull(updatedItem);
//         assertEquals(existingItem.getItemDescription(), updatedItem.getItemDescription());
//         assertEquals(existingItem.getUnitPrice(), updatedItem.getUnitPrice(), 0.001); 
     } 
 }
	 

		
	
		


