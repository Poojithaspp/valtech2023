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
public class ItemsDAOImpl implements ItemsDAO {


	public class ItemsRowMapper implements RowMapper<Items> {

		@Override
		public Items mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
		Items i =new Items();
			i.setItemId(rs.getInt(1));
			i.setItemDescription(rs.getString(2));
			i.setUnitPrice(rs.getFloat(3));
			i.setCompId(rs.getInt(4));
			return i;
			
		}
}
	@Autowired
	private DataSource dataSource;
	
	

	@Override
	public long count() {
		String countQry = "SELECT COUNT(ITEMID) FROM ITEMS";
		return new JdbcTemplate(dataSource).queryForObject(countQry, Long.class);
	}
	

	@Override
	public void createItem(Items items)
	{
		String createQry="insert into items (itemdescription,unitprice,compid) values (?,?,?)";
		new JdbcTemplate(dataSource).update(createQry,items.getItemDescription(),items.getUnitPrice(),items.getCompId());
	}	
	
	@Override
	public void deleteItem(int itemId) {
		String deleteQry = "DELETE FROM items WHERE itemid = ?";
		new JdbcTemplate(dataSource).update(deleteQry, itemId);
	}

	@Override
	public void updateItem(Items items)  {
		String updateQry="UPDATE items set itemdescription = ? , unitprice= ? ,compid=? where itemid=?";
		new JdbcTemplate(dataSource).update(updateQry,items.getItemDescription(),items.getUnitPrice(),items.getCompId());
}

	@Override
	public List<Items> getAllItems() {
		String selectAllQry="select itemdescription,unitprice ,compid from items";
		return new JdbcTemplate(dataSource).query(selectAllQry,new ItemsRowMapper());
	}

	@Override
	public Items getItems(int itemId)  {
		String selectQry="select itemid , itemdescription ,unitprice ,compid from items where itemid=?";
		return new JdbcTemplate(dataSource).queryForObject(selectQry,new ItemsRowMapper());
	}
}
