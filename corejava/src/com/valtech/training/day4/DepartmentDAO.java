package com.valtech.training.day4;
import java.sql.SQLException;
import java.util.List;

 

public interface DepartmentDAO {

 

	void createDepartment(Department dept) throws SQLException;

 

	List<Department> getDepartments() throws SQLException;

 

	void updateDepartment(Department dept) throws SQLException;

 

	void deleteDepartment(int id) throws SQLException;

 

	Department getDepartment(int id) throws SQLException;
}

