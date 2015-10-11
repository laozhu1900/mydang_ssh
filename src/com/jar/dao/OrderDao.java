package com.jar.dao;

import com.jar.domain.Order;
import com.jar.domain.ReceiveAddr;

public interface OrderDao {

	void saveReceiveAddr(ReceiveAddr addr);
	
	void saveOrder(Order order);
	
}
