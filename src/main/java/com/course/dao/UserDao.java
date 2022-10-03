package com.course.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.course.model.User;
import com.course.util.DbConnection;
import com.course.util.Queries;

public class UserDao implements IUserDao {

	@Override
	public String addUser(User user) {
		Connection connection = DbConnection.openConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(Queries.QueryAddUser);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getName());
			statement.setLong(3, user.getMobile());
			statement.setString(4, user.getEmail());
			statement.setString(5, user.getPassword());
			statement.setInt(6, 0);
			boolean check = statement.execute();
			if (check == false) {
				System.out.println("user added");
				System.out.println("Note the password-");
			}
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

		return user.getPassword();
	}

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

	@Override
	public int buyCourse(int courseId, String username) {
			Connection connection=null;
			PreparedStatement statement=null;
			int output=0;
			connection =DbConnection.openConnection();
			try {
				statement=connection.prepareStatement(Queries.QueryBuyCourse);
				statement.setInt(1, courseId);
				statement.setString(2, username);
				output=statement.executeUpdate();
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
		return output;
	}

}
