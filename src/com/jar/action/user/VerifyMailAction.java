package com.jar.action.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.jar.domain.User;
import com.jar.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class VerifyMailAction extends ActionSupport {

	private String code;

	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String verifyMail() throws Exception {

		HttpServletRequest request = ServletActionContext.getRequest();

		

		HttpSession session = request.getSession();

		String emailVerifyCode = (String) session.getAttribute("emailVerifyCode");
		
		System.out.println(code);
		
		System.out.println(emailVerifyCode);
		

		if (emailVerifyCode.equals(code)) {

			User user = (User) session.getAttribute("user");

			userService.addUser(user);

			return SUCCESS;
		} else {

			request.setCharacterEncoding("UTF-8");
			
			session.setAttribute("mailErrorMsg", "—È÷§¬Î ‰»Î¥ÌŒÛ");

			return ERROR;
		}
	}
}
