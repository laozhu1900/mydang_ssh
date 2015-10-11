package com.jar.domain;

import java.io.Serializable;

public class Order extends ReceiveAddr implements Serializable {

	private int id;
	private int status;
	private long orderTime;
	private String orderDesc;

	private double totalPrice;

	private double sendFee;

	private int sendId;

	private double orderPrice;

	private long sendTime;

	private int isDelete;


	public Order() {
		super();
	}

	public Order(int status, long orderTime, String orderDesc,
			double totalPrice, double sendFee, int sendId, double orderPrice,
			long sendTime, int isDelete) {
		super();
		this.status = status;
		this.orderTime = orderTime;
		this.orderDesc = orderDesc;
		this.totalPrice = totalPrice;
		this.sendFee = sendFee;
		this.sendId = sendId;
		this.orderPrice = orderPrice;
		this.sendTime = sendTime;
		this.isDelete = isDelete;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public long getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(long orderTime) {
		this.orderTime = orderTime;
	}

	public String getOrderDesc() {
		return orderDesc;
	}

	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public double getSendFee() {
		return sendFee;
	}

	public void setSendFee(double sendFee) {
		this.sendFee = sendFee;
	}

	public int getSendId() {
		return sendId;
	}

	public void setSendId(int sendId) {
		this.sendId = sendId;
	}

	public double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}

	public long getSendTime() {
		return sendTime;
	}

	public void setSendTime(long sendTime) {
		this.sendTime = sendTime;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

}
