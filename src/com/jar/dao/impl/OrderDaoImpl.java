package com.jar.dao.impl;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.jar.domain.Order;
import com.jar.domain.ReceiveAddr;

public class OrderDaoImpl extends HibernateDaoSupport implements 
			com.jar.dao.OrderDao ,HibernateCallback{

	
	public void saveOrder(Order order) {
		this.getHibernateTemplate().save(order);
		
	}




	@Override
	public Object doInHibernate(Session arg0) throws HibernateException,
			SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	@Override
	public void saveReceiveAddr(ReceiveAddr addr) {
		
		this.getHibernateTemplate().save(addr);
	}

	
	
}
