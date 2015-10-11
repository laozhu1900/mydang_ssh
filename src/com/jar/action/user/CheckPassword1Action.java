package com.jar.action.user;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

public class CheckPassword1Action {

	private String password;
	private String password1;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String execute() throws Exception {

		try {
			String responseText = "";

			HttpServletRequest request = ServletActionContext.getRequest();

			String password = request.getParameter("password");
			String password1 = request.getParameter("password1");

			if (password1.trim().equals("")) {
				responseText = "2";
			} else if (!password.equals(password1)) {
				responseText = "1";
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
