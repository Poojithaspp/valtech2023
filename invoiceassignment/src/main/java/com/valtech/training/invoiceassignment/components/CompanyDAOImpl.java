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
public class CompanyDAOImpl implements CompanyDAO {


	public class CompanyRowMapper implements RowMapper<Company> {

		@Override
		public Company mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
		Company c=new Company();
			c.setCompId(rs.getInt(1));
			c.setCompName(rs.getString(2));
			c.setAddress(rs.getString(4));
			return c;
			
		}
}
	@Autowired
	private DataSource dataSource;
	
	@Override
	public long count() {
		String countQry = "SELECT COUNT(CompId) FROM COMPANY";
		return new JdbcTemplate(dataSource).queryForObject(countQry, Long.class);
	}
	
	@Override
	public void createCompany(Company comp)
	{
		String createQry="insert into company (compname,address) values (?,?)";
		new JdbcTemplate(dataSource).update(createQry,comp.getCompName(),comp.getAddress());
	}	
	
	@Override
	public void deleteCompany(int compId) {
		String deleteQry = "DELETE FROM company WHERE compid = ?";
		new JdbcTemplate(dataSource).update(deleteQry, compId);
	}
	
	@Override
	public void updateCompany(Company comp)  {
		String updateQry="UPDATE company set compname = ? , address = ?  where compid=?";
		new JdbcTemplate(dataSource).update(updateQry,comp.getCompName(),comp.getAddress(),comp.getCompId());
}

	
	@Override
	public List<Company> getAllCompanies() {
		String selectAllQry="select compname,address from company";
		return new JdbcTemplate(dataSource).query(selectAllQry,new CompanyRowMapper());
	}
	
	@Override
	public Company getCompanies(int compId)  {
		String selectQry="select compname,address from company where Compid=?";
		
		return new JdbcTemplate(dataSource).queryForObject(selectQry,new CompanyRowMapper());
	}

}
