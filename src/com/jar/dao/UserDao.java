package com.jar.dao;

import com.jar.domain.User;

public interface UserDao {

	public void save(User user) throws Exception;

	public User findByEmail(String email) throws Exception;
	
	public User findByNickname(String nickname) throws Exception;
	
	public void modfiy_is_email_verify(User user) throws Exception;

	public void modfiyTimeIp(User user) throws Exception;
	
	public User login(String email,String password);

}
