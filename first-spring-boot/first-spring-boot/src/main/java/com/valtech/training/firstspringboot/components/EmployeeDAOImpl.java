package com.valtech.training.firstspringboot.components;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAOImpl {

	void deleteEmployee(int id) ;

	void updateEmployee(Employee emp) ;

	void createEmployee(Employee emp);
	//	private void populatePreparedStatementFromEmployee(Employee emp, PreparedStatement ps) throws SQLException {
	//
	//		ps.setString(1, emp.getName());
	//
	//		ps.setInt(2, emp.getAge());
	//
	//		ps.setInt(3, emp.getExperience());
	//
	//		ps.setInt(4, emp.getSeniority());
	//
	//		ps.setInt(5, emp.getSalary());
	//
	//	}

	List<Employee> getAllEmployees() ;

	Employee getEmployee(int id);

	long count();

}