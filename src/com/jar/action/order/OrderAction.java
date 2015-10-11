package com.jar.action.order;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.jar.domain.Order;
import com.jar.domain.ReceiveAddr;
import com.jar.service.OrderService;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.net.httpserver.Authenticator.Success;

public class OrderAction extends ActionSupport{


	private OrderService orderService;

	private String receiveName;

	private String fullAddress;
	private String postalCode;
	private String phone; 
	private String mobile;
	
//	private String orderDesc;
//	
//	private double  totalprice;
//	
//	private Order order;

	private long orderId;
	

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	private int userId;
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public String getReceiveName() {
		return receiveName;
	}

	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}

	public String getFullAddress() {
		return fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public String saveAddr(){
		
		ReceiveAddr addr = new ReceiveAddr(userId,receiveName, fullAddress, postalCode, mobile, phone, 1);
		
//		 order= new Order(1, Long.parseLong(new SimpleDateFormat().format(new Date())), orderDesc,
//				
//				 totalprice, 5.0, 1001, 5.0,
//				 
//				 Long.parseLong(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())), 0);
//			
//		
//		orderService.saveOrder(order);
		
		orderId =  (Long)System.currentTimeMillis();
		
		orderService.addReceiveAddr(addr);
		
		
		
		return SUCCESS;
	}
	
	
	
}
