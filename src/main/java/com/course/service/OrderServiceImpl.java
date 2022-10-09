/**
 * 
 */
package com.course.service;

import com.course.dao.IOrderDao;
import com.course.dao.OrderDaoImpl;
import com.course.model.Order;

/**
 * @author JagannathSutar
 *
 */
public class OrderServiceImpl implements IOrderService {

	IOrderDao orderDao=new OrderDaoImpl();

	/**
	 * @param username
	 * @return order 
	 * method use to get the orderDetails of user
	 */
	@Override
	public Order orderDetails(String username) {

		return orderDao.orderDetails(username);
	}

}
