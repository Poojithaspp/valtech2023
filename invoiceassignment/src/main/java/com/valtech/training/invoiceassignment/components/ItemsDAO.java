package com.valtech.training.invoiceassignment.components;

import java.util.List;

public interface ItemsDAO {

	long count();

	void createItem(Items items);

	void deleteItem(int itemId);

	void updateItem(Items items);

	List<Items> getAllItems();

	Items getItems(int itemId);

}