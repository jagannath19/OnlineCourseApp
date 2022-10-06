package com.course.service;

import com.course.dao.IUserDao;
import com.course.dao.UserDaoImpl;
import com.course.exception.InvalidInputException;
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
	public int changePassword(String username,String password) throws InvalidInputException{
		if(password.length()==8)
		return userDao.changePassword(username, password);
		else
			throw new InvalidInputException("Password should be 8 characters only");
	}

	

	@Override
	public Order orderDetails(String username) {
		
		return userDao.orderDetails(username);
	}

}
