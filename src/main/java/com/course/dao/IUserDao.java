package com.course.dao;

import com.course.model.Order;
import com.course.model.User;

/**
 * @author JagannathSutar
 *
 */
public interface IUserDao {
	String addUser(User user);
	
	User login(String username,String password);
	int changePassword(String username,String password);
	
	Order orderDetails(String username);

}
