package com.jar.domain;

import java.io.Serializable;

public class User implements Serializable {

	private Integer id;
	private String email;
	private String nickname;
	private String password;
	private Integer userIntegral;
	private int isEmailVerify;
	private String emailVerifyCode;
	private long lastLoginTime;
	private String lastLoginIp;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getUserIntegral() {
		return userIntegral;
	}

	public void setUserIntegral(Integer userIntegral) {
		this.userIntegral = userIntegral;
	}

	public int getIsEmailVerify() {
		return isEmailVerify;
	}

	public void setIsEmailVerify(int isEmailVerify) {
		this.isEmailVerify = isEmailVerify;
	}

	public String getEmailVerifyCode() {
		return emailVerifyCode;
	}

	public void setEmailVerifyCode(String emailVerifyCode) {
		this.emailVerifyCode = emailVerifyCode;
	}

	public long getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(long lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public User() {
		super();
	}

	public User(String email, String nickname, String password,
			Integer userIntegral, int isEmailVerify, String emailVerifyCode,
			long lastLoginTime, String lastLoginIp) {
		super();
		this.email = email;
		this.nickname = nickname;
		this.password = password;
		this.userIntegral = userIntegral;
		this.isEmailVerify = isEmailVerify;
		this.emailVerifyCode = emailVerifyCode;
		this.lastLoginTime = lastLoginTime;
		this.lastLoginIp = lastLoginIp;
	}

	public User(Integer id, String email, String nickname, String password,
			Integer userIntegral, int isEmailVerify, String emailVerifyCode,
			long lastLoginTime, String lastLoginIp) {
		super();
		this.id = id;
		this.email = email;
		this.nickname = nickname;
		this.password = password;
		this.userIntegral = userIntegral;
		this.isEmailVerify = isEmailVerify;
		this.emailVerifyCode = emailVerifyCode;
		this.lastLoginTime = lastLoginTime;
		this.lastLoginIp = lastLoginIp;
	}

}
