package com.jar.action.user;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.mail.MailSender;

import com.jar.domain.User;
import com.jar.mail.MailSend;
import com.jar.mail.MailSenderInfo;
import com.jar.service.UserService;
import com.jar.util.UserUtil;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {

	private UserService userService;

	private String nickname;
	private String password;
	private String email;

	private String password1;
	
	
	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public UserService getUserService() {
		return userService;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String register() throws Exception {
		
		boolean checknickname = (nickname.matches("^[0-9a-z\\u4e00-\\u9fa5]+$")
				&& (nickname.length() >= 4) && (nickname.length() <= 20));
		boolean checkpassword = password.matches("^[a-zA-Z0-9]{6,20}");
		
		boolean checkpassword1 = (password.equals(password1));
		
		boolean checkemail = email.matches("^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$"   );
		

		HttpServletRequest request = ServletActionContext.getRequest();
		
		String number = request.getParameter("number");
		
		HttpSession session = request.getSession();
		
		String ImgCode = (String) session.getAttribute("ImgCode");
		
		boolean checkImgcode = number.equals(ImgCode) ;
		

		if(checkemail&&checkImgcode&&checknickname&&checkpassword1&&checkpassword){
			
			String emailVerifyCode = new UserUtil().createEmailVerifyCode();
			
			session.setAttribute("emailVerifyCode",emailVerifyCode);
			
			long lastLoginTime = new UserUtil().getCurrentTime();
			
			String remoteAddr = new UserUtil().getIpAddr(ServletActionContext.getRequest());
			
			User user = new User(email, nickname, password, 0, 1, emailVerifyCode, lastLoginTime, remoteAddr);
			
			session.setAttribute("user", user);
			
			MailSend mail = new MailSend();
			
			mail.send(email,emailVerifyCode);
			
			return SUCCESS;
		}else{
			
			return ERROR;
			
		}
		
		
//		String remoteAddr = ServletActionContext.getRequest().getRemoteAddr();
////		String remoteAddr = new UserUtil().getIpAddr(ServletActionContext.getRequest());
//
//		String emailVerifyCode = new UserUtil().createEmailVerifyCode();
//
//		long lastLoginTime = new UserUtil().getCurrentTime();
//
//		User user = new User(email, nickname, password, 0, 0,
//				emailVerifyCode, lastLoginTime, remoteAddr);
//
//		try {
//			userService.addUser(user);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return SUCCESS;

	}

}
