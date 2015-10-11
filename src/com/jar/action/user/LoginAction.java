package com.jar.action.user;

import org.apache.struts2.ServletActionContext;

import com.jar.domain.User;
import com.jar.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{

	private String email;
	private String password;

	private UserService userService;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String login() throws Exception {

		User user = userService.login(email, password);
		
		if(user!=null){
			ServletActionContext.getRequest().setAttribute("user", user);
			ServletActionContext.getRequest().getSession().setAttribute("user", user);
			return SUCCESS;
		}else{
			ServletActionContext.getRequest().setAttribute("login_error", "’À∫≈/√‹¬Î¥ÌŒÛ");
			return ERROR;
		}
		
	}

}
