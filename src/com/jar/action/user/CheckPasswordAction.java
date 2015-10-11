package com.jar.action.user;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

public class CheckPasswordAction {

	public String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String execute() throws Exception {

		try {
			String responseText = "";

			HttpServletRequest request = ServletActionContext.getRequest();

			String password = request.getParameter("password");

			if (password.trim().equals("")) {
				responseText = "1";
			} else if (!password.matches("^[a-zA-Z0-9]{6,20}")) {
				responseText = "2";
			} else {
				responseText = "3";
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
