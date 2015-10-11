package com.jar.action.user;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.jar.domain.User;
import com.jar.service.UserService;

public class CheckNicknameAction {

	private String nickname;

	private UserService userService;

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String execute() throws Exception {

		try {
			String responseText = "";

			HttpServletRequest request = ServletActionContext.getRequest();
			String nickname = request.getParameter("nickname");

			if (nickname.trim().equals("")) {
				responseText = "1";
			} else {
				if (!(nickname.matches("^[0-9a-z\\u4e00-\\u9fa5]+$")
						&& (nickname.length() >= 4) && (nickname.length() <= 20))) {
					responseText = "2";
				} else {

					User user = userService.findByNickname(nickname);

					if (user == null) {
						responseText = "3";
					} else {
						responseText = "4";
					}
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
