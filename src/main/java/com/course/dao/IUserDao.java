/**
 * 
 */
package com.course.dao;

import com.course.model.User;

/**
 * @author JagannathSutar
 *
 */
public interface IUserDao {
	public String addUser(User user);
	public User login(String username, String password);
	public int changePassword(String username,String password);
	

}
