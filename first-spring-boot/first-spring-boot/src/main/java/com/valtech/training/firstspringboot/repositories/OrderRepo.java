package com.valtech.training.firstspringboot.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.valtech.training.firstspringboot.entity.Order;
@Repository
public interface OrderRepo extends JpaRepository<Order,Long> {
	
		@Query( value ="SELECT o FROM Order o WHERE o.itemcount= ?1")
		List<Order> findAllByItemcount(int itemcount);
		List<Order> findAllByItemAndItemcount(String item,int  itemcount);
		int countByItem(String item);
}

