package com.valtech.training.day4;
import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.ArrayList;

import java.util.List;

public class EmployeeDAO implements EmployeeDAOImpl {
@Override
public void deleteEmployee(int id) throws SQLException {
	Connection conn = getConnection();

PreparedStatement ps = conn.prepareStatement("DELETE FROM EMPLOYEE WHERE ID = ?");

ps.setInt(1, id);

int rowsUpdated = ps.executeUpdate();

System.out.println("Rows Updated "+rowsUpdated);

conn.close();


	}

	

	@Override 
	public void updateEmployee(Employee emp) throws SQLException {
		Connection conn =getConnection();

		PreparedStatement ps = conn.prepareStatement("UPDATE EMPLOYEE SET NAME= ? , AGE = ? , EXPERIENCE = ? , SENIORITY = ? ,SALARY = ? WHERE ID = ?");

		populatePreparedStatementFromEmployee(emp, ps);

		ps.setInt(6,emp.getId());

		int rowsUpdated = ps.executeUpdate();

		System.out.println("Rows updated "+rowsUpdated);

		conn.close();

		

	}

	

	@Override
	public void createEmployee(Employee emp) throws SQLException

	{

		Connection conn =getConnection();

		PreparedStatement ps = conn.prepareStatement("insert into employee (name,age,experience,seniority,salary)values (?,?,?,?,?)");
	
		ps.setString(1, emp.getName());

		ps.setInt(2, emp.getAge());

		ps.setInt(3, emp.getExperience());

		ps.setInt(4, emp.getSeniority());

		ps.setInt(5, emp.getSalary());
	populatePreparedStatementFromEmployee(emp, ps);

		int rowsUpdated = ps.executeUpdate();

		System.out.println("Rows updated "+rowsUpdated);

	}
	private void populatePreparedStatementFromEmployee(Employee emp, PreparedStatement ps) throws SQLException {

		ps.setString(1, emp.getName());

		ps.setInt(2, emp.getAge());

		ps.setInt(3, emp.getExperience());

		ps.setInt(4, emp.getSeniority());

		ps.setInt(5, emp.getSalary());

	}

	

	@Override
	public List<Employee> getAllEmployees() throws SQLException{

		Connection conn =getConnection();

		PreparedStatement ps = conn.prepareStatement("select id,name,age,experience,seniority,salary from employee");

		ResultSet rs =ps.executeQuery();

		List<Employee> emps =new ArrayList<>();

		while(rs.next())

		{

			emps.add(mapRowToEmployee(rs));

		}

		conn.close();

		return emps;

		

	}

	@Override
	public Employee getEmployee(int id) throws SQLException {


		Connection conn = getConnection();

		PreparedStatement ps = conn.prepareStatement("select id,name,age,experience,seniority,salary from employee where id=?");

		ps.setInt(1,id);

		ResultSet rs= ps.executeQuery();

		if(rs.next()) {

			Employee e = mapRowToEmployee(rs);

			conn.close();

			return e;

	

		} else {

			System.out.println("No row with id = "+id +"found.....");

			return null;

		}

	}

 

	private Employee mapRowToEmployee(ResultSet rs) throws SQLException {

		Employee e = new Employee();

		e.setId(rs.getInt(1));

		e.setName(rs.getString(2));

		e.setAge(rs.getInt(3));

		e.setExperience(rs.getInt(4));

		e.setSeniority(rs.getInt(5));

		e.setSalary(rs.getInt(6));
//		conn.close();

		return e;

	}

	static {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		}

	}

 

	private Connection getConnection() throws SQLException {

		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/valtech2023?useSSL=false", "root","root");

		return conn;

	}

	

	public static void main(String[] args) throws SQLException {

		EmployeeDAOImpl dao =new EmployeeDAO();

System.out.println(dao.getEmployee(1));

System.out.println(dao.getEmployee(2));

dao.createEmployee(new Employee("xyz",35,4,1,50000));
//Employee e =dao.getEmployee(2);
//
//e.setSeniority(2);
//
//dao.updateEmployee(e);

System.out.println(dao.getAllEmployees());

	

		
	}

 

}

 


