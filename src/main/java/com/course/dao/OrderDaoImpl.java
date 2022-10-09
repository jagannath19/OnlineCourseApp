/**
 * 
 */
package com.course.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.course.model.Order;
import com.course.util.DbConnection;
import com.course.util.Queries;

/**
 * @author JagannathSutar
 *
 */
public class OrderDaoImpl implements IOrderDao {

	/**
	 * @param username
	 * @return order details 
	 * method use to show the order of the user
	 */
	@Override
	public Order orderDetails(String username) {
		Order order=new Order();
		Connection connection=null;
		PreparedStatement statement=null;
		connection=DbConnection.openConnection();
		try {
			statement=connection.prepareStatement(Queries.QueryOrderDetais);
			statement.setString(1, username);
			ResultSet resultset=statement.executeQuery();
			while(resultset.next()) {
			order.setUserName(resultset.getString(1));
			order.setMobile(resultset.getLong(2));
			order.setEmail(resultset.getString(3));
			order.setCourseName(resultset.getString(4));
			order.setFacultyName(resultset.getString(5));
			order.setMode(resultset.getString(6));
			order.setCategory(resultset.getString(7));
			order.setDurationInDays(resultset.getInt(8));
			order.setCourseFee(resultset.getDouble(9));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(statement!=null)
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			DbConnection.closeConnection();
		}
		return order;
	}

	
}
