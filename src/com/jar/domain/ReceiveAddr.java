package com.jar.domain;

public class ReceiveAddr {

	
	private User user;
	
	

	private int id;

	private int userId;

	private String receiveName;

	private String fullAddress;

	private String postalCode;

	private String mobile;

	private String phone;

	private int isDefault;
	
	
	
	

	


	public ReceiveAddr() {
		super();
	}

	public ReceiveAddr(int userId, String receiveName, String fullAddress,
			String postalCode, String mobile, String phone, int isDefault) {
		super();
		this.userId = userId;
		this.receiveName = receiveName;
		this.fullAddress = fullAddress;
		this.postalCode = postalCode;
		this.mobile = mobile;
		this.phone = phone;
		this.isDefault = isDefault;
	}

	public ReceiveAddr(int id, int userId, String receiveName,
			String fullAddress, String postalCode, String mobile, String phone,
			int isDefault) {
		super();
		this.id = id;
		this.userId = userId;
		this.receiveName = receiveName;
		this.fullAddress = fullAddress;
		this.postalCode = postalCode;
		this.mobile = mobile;
		this.phone = phone;
		this.isDefault = isDefault;
	}

	public int getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(int isDefault) {
		this.isDefault = isDefault;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	
	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	

	

}
