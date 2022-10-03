package com.course.service;

import com.course.dao.IUserDao;
import com.course.dao.UserDao;
import com.course.model.User;

public class UserService implements IUserService {
	IUserDao userDao=new UserDao();
	@Override
	public String addUser(User user) {
		
		return userDao.addUser(user);
	}

	@Override
	public User login(String username, String password) {
			
		return userDao.login(username, password);
	}

	@Override
	public int changePassword(String username,String password) {
		// TODO Auto-generated method stub
		return userDao.changePassword(username, password);
	}

	@Override
	public int buyCourse(int courseId, String username) {
		
		return userDao.buyCourse(courseId, username);
	}

}
