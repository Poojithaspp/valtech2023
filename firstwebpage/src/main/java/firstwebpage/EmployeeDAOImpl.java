package firstwebpage;



import java.sql.SQLException;
import java.util.List;


public interface EmployeeDAOImpl {
	
	long count() throws SQLException;
	
	int firstID() throws SQLException;
	
	int lastID()  throws SQLException;
	
	int nextID(int id)  throws SQLException;
	
	int previousID(int id)  throws SQLException;
//	void employeeView(int id) throws SQLException;
	
	void deleteEmployee(int id) throws SQLException;

	void updateEmployee(Employee emp) throws SQLException;

	void createEmployee(Employee emp) throws SQLException;

	List<Employee> getEmployees() throws SQLException;

	Employee getEmployee(int id) throws SQLException;

}

