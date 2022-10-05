package com.course.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.course.model.Order;
import com.course.model.User;
import com.course.util.DbConnection;
import com.course.util.PasswordGenerator;
import com.course.util.Queries;

/**
 * @author JagannathSutar
 * @implNote implements IUserDao interface
 * This class use for do all the user operation with database
 *
 */
public class UserDaoImpl implements IUserDao {
	
	/**
	 * @param user
	 * @return auto generated password
	 * this method use to add a new user in database
	 */
	@Override
	public String addUser(User user) {
		Connection connection = DbConnection.openConnection();
		PreparedStatement statement = null;
		boolean check =true;
		String password=PasswordGenerator.autoPassword();
		try {
			statement = connection.prepareStatement(Queries.QueryAddUser);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getName());
			statement.setLong(3, user.getMobile());
			statement.setString(4, user.getEmail());
			statement.setString(5, password);
			statement.setInt(6, 0);
			 check=statement.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		DbConnection.closeConnection();
		if (!check) {
			System.out.println("user added");
			System.out.println("Note the password-");
		}

		return password;
	}
	
	
	/**
	 * @param username
	 * @param password
	 * @return User object
	 * this method is use to verify user name and password of the user and admin
	 */

	@Override
	public User login(String username, String password) {
		Connection connection = DbConnection.openConnection();
		PreparedStatement statement = null;
		User user = new User();
		try {
			statement = connection.prepareStatement(Queries.QueryLogin);
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				user.setUsername(resultset.getString(1));
				user.setName(resultset.getString(2));
				user.setMobile(resultset.getLong(3));
				user.setEmail(resultset.getString(4));
				user.setPassword(resultset.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		DbConnection.closeConnection();

		return user;
	}
	/**
	 * @param username
	 * @param password
	 * this method is use to change the login password
	 */
	@Override
	public int changePassword(String username,String password) {
		Connection connection = null;
		PreparedStatement statement = null;
		int output=0;
		try {
			connection = DbConnection.openConnection();
			statement = connection.prepareStatement(Queries.QueryChangePassword);
			statement.setString(1, password);
			statement.setString(2, username);
			 output = statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			DbConnection.closeConnection();
		}
		return output;

		
	}
	
	
	/**
	 * @param username
	 * @return Order object
	 * This method use to see the order details
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
