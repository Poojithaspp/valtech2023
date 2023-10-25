package com.valtech.training.day4;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

 

public class DeptDAOImpl implements DepartmentDAO
{

 

	@Override
	public void createDepartment(Department dept) throws SQLException {

		Connection con=getConnection();

 

		PreparedStatement ps=con.prepareStatement("INSERT INTO DEPARTMENT (DID,DNAME,LOCATION) VALUES(?,?,?)");

 

		populatePreparedStatment(dept, ps);

 

		int rowsUpdated=ps.executeUpdate();

 

		System.out.println("Rows update:"+rowsUpdated);

 

		con.close();
		// TODO Auto-generated method stub

	}

 

	@Override
	public List<Department> getDepartments() throws SQLException {
		Connection con=getConnection();

 

		PreparedStatement ps=con.prepareStatement("SELECT * FROM DEPARTMENT");

 

		ResultSet rs=ps.executeQuery();

 

		List<Department> dept=new ArrayList<>();

 

		while(rs.next()) {

 

			dept.add(mapSingleRow(rs));

 

		}

 

		con.close();

 

		return dept;
	}

 

	@Override
	public void updateDepartment(Department dept) throws SQLException {
		// TODO Auto-generated method stub

		Connection con=getConnection();

 

		PreparedStatement ps=con.prepareStatement("UPDATE DEPARTMENT SET DID=?,DNAME=?,LOCATION=? WHERE DID=? ");

 

		populatePreparedStatment(dept, ps);

 

		ps.setInt(4, dept.getDid());

 

		int rowsUpdated=ps.executeUpdate();

 

		System.out.println("Rows update:"+rowsUpdated);

 

		con.close();	

	}

 

	@Override
	public void deleteDepartment(int id) throws SQLException {
		// TODO Auto-generated method stub

		Connection con=getConnection();

 

		PreparedStatement ps=con.prepareStatement("DELETE FROM DEPARTMENT WHERE DID=?");

 

		ps.setInt(1, id);

 

		int rowsUpdated=ps.executeUpdate();

 

		System.out.println("Rows update:"+rowsUpdated);

 

		con.close();

	}

 

	@Override
	public Department getDepartment(int id) throws SQLException {
		Connection con=getConnection();

 

		PreparedStatement ps=con.prepareStatement("SELECT * FROM DEPARTMENT WHERE DID=?");

 

		ps.setInt(1, id);

 

		ResultSet rs=ps.executeQuery();

 

		if(rs.next()) {

 

			Department dept = mapSingleRow(rs);

 

			con.close();

 

			return dept;

 

		}

 

		else {

 

			System.out.println("No DeptId found "+id+" ,Couldn't fetch data");

 

			return null;
	}
	}

 

	

 

	private Department mapSingleRow(ResultSet rs) throws SQLException {

 

		Department dept=new Department();

 

		dept.setDid(rs.getInt(1));

 

		dept.setDname(rs.getString(2));

 

		dept.setLocation(rs.getString(3));

 

//		dept.setEmpList(rs.getInt(4));

 

		return dept;

 

	}

 

	

 

	private void populatePreparedStatment(Department dept, PreparedStatement ps) throws SQLException {

 

		ps.setInt(1, dept.getDid());

 

		ps.setString(2, dept.getDname());

 

		ps.setString(3, dept.getLocation());

 

	}

 

	

 

	//Static methods are initialized as soon as an object instance is created

 

	static {

 

		try {

 

			Class.forName("com.mysql.cj.jdbc.Driver");

 

		} catch (ClassNotFoundException e) {

 

			e.printStackTrace();

 

		}

 

	}

 

	

 

	private Connection getConnection() throws SQLException {

 

		return DriverManager.getConnection("jdbc:mysql://localhost:3306/valtech2023?useSSL=false&allowPublicKeyRetrieval=true","root","root");

 

	}

 

	

 

	public static void main(String[] args) throws SQLException {

 

		DepartmentDAO dept=new DeptDAOImpl();

 

		System.out.println(dept.getDepartment(1));

 

		System.out.println("---------------------");

 

		System.out.println(dept.getDepartments());

 

		

 

		// Create Operation

 

System.out.println("---------------------");
	System.out.println("Creating Department");

	dept.createDepartment(new Department(1,"R&D","Bengaluru","null","null"));
//
	

 

//		 Update Operation

 

//	System.out.println("---------------------");
//
//	System.out.println("Updating Department");
//
//		Department dept1=dept.getDepartment(2);
//
//		dept1.setDname("IT");
//
//		dept.updateDepartment(dept1);

 

		

 

		// Delete Operation

 
//
//		System.out.println("---------------------");
//
// 
//
//		System.out.println("Delete Operation");
//
// 
//
//		dept.deleteDepartment(1);

 

		

 

		

 

	}

 

}
