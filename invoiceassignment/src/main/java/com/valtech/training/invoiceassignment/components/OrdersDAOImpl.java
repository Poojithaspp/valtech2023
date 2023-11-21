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
public class OrdersDAOImpl implements OrdersDAO {

	public class OrdersRowMapper implements RowMapper<Orders> {

		@Override
		public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Orders o = new Orders();
			o.setOrderId(rs.getInt(3));
			o.setDate(rs.getString(2));
			o.setCustId(rs.getInt(3));
			return o;

		}
	}

	@Autowired
	private DataSource dataSource;

	@Override
	public long count() {
		String countQry = "SELECT COUNT(OrderId) FROM Orders";
		return new JdbcTemplate(dataSource).queryForObject(countQry, Long.class);
	}

	@Override
	public void createOrder(Orders order) {
		String createQry = "insert into orders (date,Custid) values (?,?)";
		new JdbcTemplate(dataSource).update(createQry, order.getDate(), order.getCustId());
	}

	@Override
	public void deleteOrder(int orderid) {
		String deleteQry = "DELETE FROM orders WHERE orderid = ?";
		new JdbcTemplate(dataSource).update(deleteQry, orderid);
	}

	@Override
	public void updateOrder(Orders order) {
		String updateQry = "UPDATE orders set date=?,custid=? where orderid=? ";
		new JdbcTemplate(dataSource).update(updateQry, order.getDate(),order.getCustId(),order.getOrderId());
	}

	@Override
	public List<Orders> getAllOrders() {
		String selectAllQry = "select orderid ,date,custid from orders";
		return new JdbcTemplate(dataSource).query(selectAllQry, new OrdersRowMapper());
	}

	@Override
	public Orders getOrders(int orderid) {
		String selectQry = "select orderid ,date,custid from orders";

		return new JdbcTemplate(dataSource).queryForObject(selectQry, new OrdersRowMapper());
	}
}
