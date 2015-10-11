package com.jar.service;

import com.jar.domain.User;

public interface UserService {

	public void addUser(User user) throws Exception;

	public User findByEmail(String email) throws Exception;
	
	public User findByNickname(String nickname) throws Exception;
	
	public User login(String email,String password) throws Exception;
}
