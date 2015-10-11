package com.jar.action.user;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.jar.dao.UserDao;
import com.jar.domain.User;
import com.jar.service.UserService;

public class CheckEmailAction {

	public String email;

	public UserService userService;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String execute() throws Exception {

		try {
			String responseText = "";
			HttpServletRequest request = ServletActionContext.getRequest();
			String email = request.getParameter("email");

			if (email.trim().equals("")) {
				responseText = "3";
			}else if(!email.matches("^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$"   )){
				responseText = "4";
			}else {
				User user = userService.findByEmail(email);
				if (user == null) {
					responseText = "2";
				} else {
					responseText = "1";
				}
			}

			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print(responseText);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
