package firstwebpage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//CRUD
//Create
//read
//update
//delete

public class EmployeeDAO implements EmployeeDAOImpl {

	@Override
	public void deleteEmployee(int id) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement("DELETE FROM EMPLOYEE WHERE ID = ? ");
		ps.setInt(1, id);
		int rowsUpdated = ps.executeUpdate();
		System.out.println("Rows updated " + rowsUpdated);
		conn.close();

	}

	@Override
	public void updateEmployee(Employee emp) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement(
				"UPDATE EMPLOYEE SET NAME= ? , AGE = ? , EXPERIENCE = ? , SENIORITY = ? ,SALARY = ? WHERE ID = ?");
		populatePreparedStatementFromEmployee(emp, ps);
		ps.setInt(6, emp.getId());
		int rowsUpdated = ps.executeUpdate();
		System.out.println("Rows updated " + rowsUpdated);
		conn.close();

	}

	@Override
	public void createEmployee(Employee emp) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement ps = conn
				.prepareStatement("INSERT INTO EMPLOYEE (NAME,AGE,EXPERIENCE,SENIORITY,SALARY) VALUES (?,?,?,?,?)");
		populatePreparedStatementFromEmployee(emp, ps);
		int rowsUpdated = ps.executeUpdate();
		System.out.println("Rows updated " + rowsUpdated);
		conn.close();
	}

	private void populatePreparedStatementFromEmployee(Employee emp, PreparedStatement ps) throws SQLException {
		ps.setString(1, emp.getName());
		ps.setInt(2, emp.getAge());
		ps.setInt(3, emp.getExperience());
		ps.setInt(4, emp.getSeniority());
		ps.setInt(5, emp.getSalary());
	}

	@Override
	public List<Employee> getEmployees() throws SQLException {
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT ID,NAME,AGE,EXPERIENCE,SENIORITY,SALARY FROM EMPLOYEE");
		ResultSet rs = ps.executeQuery();
		List<Employee> emps = new ArrayList<>();
		while (rs.next()) {
			emps.add(mapRowToEmployee(rs));
		}
		conn.close();
		return emps;

	}

	@Override
	public Employee getEmployee(int id) throws SQLException {

		Connection conn = getConnection();
		PreparedStatement ps = conn
				.prepareStatement("SELECT ID,NAME,AGE,EXPERIENCE,SENIORITY,SALARY FROM EMPLOYEE WHERE ID=?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			Employee e = mapRowToEmployee(rs);
			conn.close();
			return e;

		} else {
			System.out.println("No row with id = " + id + "found.....");
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
		return e;
	}

	// this static block is to run the static block code only once
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/valtech2023?useSSL=false", "root",
				"root");
		return conn;
	}

	public static void main(String[] args) throws SQLException {
		EmployeeDAO dao = new EmployeeDAO();
//		System.out.println(dao.getEmployee(1));
//		System.out.println(dao.getEmployee(2));
//      dao.createEmployee(new Employee("xyz",35,4,1,50000));
//		Employee e =dao.getEmployee(5);
//		e.setSeniority(5);
//		dao.updateEmployee(e);
//		System.out.println(dao.getEmployees());
		dao.deleteEmployee(5);
		System.out.println(dao.getEmployees());
		dao.count();

	}

	@Override
	public long count() throws SQLException {
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement("Select Count(id) from Employee");
		ResultSet rs = ps.executeQuery();
		rs.next();
		long count = rs.getLong(1);
		System.out.println("Count =" + count);
		conn.close();
		return count;
	}

	@Override
	public int firstID() throws SQLException {
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement("select min(id) from employee");
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			int id = rs.getInt(1);
			conn.close();
			return id;
		}
		return 0;
	}

	@Override
	public int lastID() throws SQLException {
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement("select max(id) from employee");
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			int id = rs.getInt(1);
			conn.close();
			return id;
		}
		return 0;
	}

	@Override
	public int nextID(int id) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement("select min(id) from employee where id > ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			id = rs.getInt(1);
			System.out.println("Next id=" + id);
			conn.close();

		}
		conn.close();
		return id == 0 ? lastID() : id;
	}

	@Override
	public int previousID(int id) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement("select max(id) from employee where id < ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			id = rs.getInt(1);
			System.out.println("Previous id=" + id);
			conn.close();

		}
		conn.close();
		return id == 0 ? firstID() : id;
	}

//	@Override
//	public void employeeView(int id) throws SQLException {
//		// TODO Auto-generated method stub
//		
//	}
}
