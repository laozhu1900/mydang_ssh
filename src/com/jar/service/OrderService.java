package com.jar.service;

import com.jar.domain.Order;
import com.jar.domain.ReceiveAddr;

public interface OrderService {

	void addReceiveAddr(ReceiveAddr addr);

	void saveOrder(Order order);
	
}
