package com.course.service;

import com.course.model.User;

/**
 * @author JagannathSutar
 *
 */
public interface IUserService {
	String addUser(User user);
	
	User login(String username,String password);
	int changePassword(String username,String password);
	
}
