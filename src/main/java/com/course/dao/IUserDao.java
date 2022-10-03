package com.course.dao;

import com.course.model.User;

public interface IUserDao {
	String addUser(User user);
	
	User login(String username,String password);
	int changePassword(String username,String password);
	int buyCourse(int courseId,String username);

}
