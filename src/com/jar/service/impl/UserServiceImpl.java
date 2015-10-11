package com.jar.service.impl;

import com.jar.dao.UserDao;
import com.jar.domain.User;
import com.jar.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void addUser(User user) throws Exception {
		this.userDao.save(user);
		
	}

	public User findByEmail(String email) throws Exception {
		return this.userDao.findByEmail(email);
		
	}

	public User findByNickname(String nickname) throws Exception {
		return this.userDao.findByNickname(nickname);
	}

	public User login(String email, String password) throws Exception {
		
		return this.userDao.login(email, password);
	}

}
