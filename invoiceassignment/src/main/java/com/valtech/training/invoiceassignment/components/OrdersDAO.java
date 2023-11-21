package com.valtech.training.invoiceassignment.components;

import java.util.List;

public interface OrdersDAO {

	long count();

	void createOrder(Orders order);

	void deleteOrder(int orderid);

	void updateOrder(Orders order);

	List<Orders> getAllOrders();

	Orders getOrders(int orderid);

}