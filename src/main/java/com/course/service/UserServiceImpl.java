package com.course.service;

import com.course.dao.IUserDao;
import com.course.dao.UserDaoImpl;
import com.course.exception.InvalidInputException;
import com.course.model.User;

/**
 * @author JagannathSutar
 * This class methods calls the UserDao class  methods and handle exception if there
 */
public class UserServiceImpl implements IUserService {
	IUserDao userDao=new UserDaoImpl();
	/**
	 * @param user
	 * @return password as string
	 * this method use to add a new user 
	 */
	@Override
	public String addUser(User user) {
		
		return userDao.addUser(user);
	}

	/**
	 * @param username
	 * @param password
	 * @return user if user name and password match
	 * method use for login 
	 */
	@Override
	public User login(String username, String password) {
			
		return userDao.login(username, password);
	}

	/**
	 * @param username
	 * @param password
	 * @return 1 if password changed else 0
	 * @throws InvalidInputException
	 * method use for change password
	 */
	@Override
	public int changePassword(String username,String password) throws InvalidInputException{
		if(password.length()==8)
		return userDao.changePassword(username, password);
		else
			throw new InvalidInputException("Password should be 8 characters only");
	}

	

	

}
