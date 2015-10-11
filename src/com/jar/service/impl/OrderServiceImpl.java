package com.jar.service.impl;

import com.jar.dao.OrderDao;
import com.jar.domain.Order;
import com.jar.domain.ReceiveAddr;
import com.jar.service.OrderService;

public class OrderServiceImpl implements OrderService {

	private OrderDao orderDao;

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}


	public void addReceiveAddr(ReceiveAddr addr) {
		orderDao.saveReceiveAddr(addr);
		
	}


	public void saveOrder(Order order) {
		orderDao.saveOrder(order); 
		
	}

	
}
