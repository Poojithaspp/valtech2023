package com.valtech.training.invoiceassignment.components;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerDAOImpl implements CustomerDAO  {
	public class CustomerRowMapper implements RowMapper<Customer> {

		@Override
		public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
		Customer c=new Customer();
			c.setCustId(rs.getInt(1));
			c.setCustName(rs.getString(2));
			c.setCustAddress(rs.getString(3));
			c.setPhonenumber(rs.getInt(4));
			return c;
			
		}
}
	@Autowired
	private DataSource dataSource;
	
	
	@Override
	public long count() {
		String countQry = "SELECT COUNT(CUSTID) FROM CUSTOMER";
		return new JdbcTemplate(dataSource).queryForObject(countQry, Long.class);
	}
	
	@Override
	public void createCustomer(Customer cust)
	{
		String createQry="insert into customer (custname,custAddress,phonenumber) values (?,?,?)";
		new JdbcTemplate(dataSource).update(createQry,cust.getCustName(),cust.getCustAddress(),cust.getPhonenumber());
	}	
	@Override
	public void deleteCustomer(int custId) {
		String deleteQry = "DELETE FROM customer WHERE custid = ?";
		new JdbcTemplate(dataSource).update(deleteQry, custId);
	}
	@Override
	public void updateCustomer(Customer cust)  {
		String updateQry="UPDATE Customer set custname = ? , custAddress = ? , phonenumber = ? where custid=? ";
		new JdbcTemplate(dataSource).update(updateQry,cust.getCustName(),cust.getCustAddress(),cust.getPhonenumber(),cust.getCustId());
}

	@Override
	public List<Customer> getAllCustomers() {
		String selectAllQry="select custid,custname,custaddress,phonenumber from customer";
		return new JdbcTemplate(dataSource).query(selectAllQry,new CustomerRowMapper());
	}
	@Override
	public Customer getCustomers(int custId)  {
		String selectQry="select custname,custaddress,phonenumber from customer where Custid=?";
		
		return new JdbcTemplate(dataSource).queryForObject(selectQry,new CustomerRowMapper());
	}

	
	}
