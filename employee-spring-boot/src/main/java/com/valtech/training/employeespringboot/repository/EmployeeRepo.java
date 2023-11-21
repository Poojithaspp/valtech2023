package com.valtech.training.employeespringboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.valtech.training.employeespringboot.entity.Employee;



@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
	
	@Query(value = "SELECT E FROM Employee E WHERE DID = ?1")
	List<Employee> findEmployeeByDepartmentId(int did);
	
}
