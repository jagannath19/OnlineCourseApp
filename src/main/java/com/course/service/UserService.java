package com.course.service;

import com.course.dao.IUserDao;
import com.course.dao.UserDaoImpl;
import com.course.model.Order;
import com.course.model.User;

/**
 * @author JagannathSutar
 * This class methods calls the UserDao class  methods and handle exception if there
 */
public class UserService implements IUserService {
	IUserDao userDao=new UserDaoImpl();
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
	public Order orderDetails(String username) {
		
		return userDao.orderDetails(username);
	}

}
