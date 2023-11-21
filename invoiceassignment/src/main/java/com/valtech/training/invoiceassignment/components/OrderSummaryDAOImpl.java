package com.valtech.training.invoiceassignment.components;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.valtech.training.invoiceassignment.components.CustomerDAOImpl.CustomerRowMapper;
@Component
public class OrderSummaryDAOImpl implements OrderSummaryDAO{


	public class OrderSummaryRowMapper implements RowMapper<OrderSummary> {

		@Override
		public OrderSummary mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
		OrderSummary os=new OrderSummary();
			os.setItemId(rs.getInt(1));
			os.setOrderId(rs.getInt(2));
			os.setQuantity(rs.getInt(3));
			return os;
			
		}
}
	@Autowired
	private DataSource dataSource;
	
	@Override
	public void createOrderSummary(OrderSummary ordersum)
	{
		String createQry="insert into ordersummary (ItemId,OrderId,quantity) values (?,?,?)";
		new JdbcTemplate(dataSource).update(createQry,ordersum.getQuantity(),ordersum.getItemId(),ordersum.getOrderId());
	}	
	
	
	@Override
	public void updateOrdersummary(OrderSummary ordersum)  {
		String updateQry="UPDATE ordersummary set quantity=? where orderid=?  ";
		new JdbcTemplate(dataSource).update(updateQry,ordersum.getQuantity());
}

	

}
