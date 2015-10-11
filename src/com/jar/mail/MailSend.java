package com.jar.mail;

import com.jar.util.UserUtil;

public class MailSend {
	public static void main(String[] args){  
        //这个类主要是设置邮件  
     MailSenderInfo mailInfo = new MailSenderInfo();   
     mailInfo.setMailServerHost("smtp.163.com");   
     mailInfo.setMailServerPort("25");   
     mailInfo.setValidate(true);   
     mailInfo.setUserName("zhuzw0929@163.com");   
     mailInfo.setPassword("930929zzw");//您的邮箱密码   
     mailInfo.setFromAddress("zhuzw0929@163.com");   
     mailInfo.setToAddress("1206953863@qq.com");   
     mailInfo.setSubject("当当网用户注册邮箱验证");   
     mailInfo.setContent("邮箱的验证码为："+new UserUtil().createEmailVerifyCode()+"</br>"+"请尽快完成注册");   
        //这个类主要来发送邮件  
     SimpleMailSender sms = new SimpleMailSender();  
//         sms.sendTextMail(mailInfo);//发送文体格式   
         sms.sendHtmlMail(mailInfo);//发送html格式  
   }  
	
	public void send(String email,String verifyCode){
		 MailSenderInfo mailInfo = new MailSenderInfo();   
	     mailInfo.setMailServerHost("smtp.163.com");   
	     mailInfo.setMailServerPort("25");   
	     mailInfo.setValidate(true);   
	     mailInfo.setUserName("zhuzw0929@163.com");   
	     mailInfo.setPassword("930929zzw");//您的邮箱密码   
	     mailInfo.setFromAddress("zhuzw0929@163.com");   
	     mailInfo.setToAddress(email);   
	     mailInfo.setSubject("当当网用户注册邮箱验证");   
	     mailInfo.setContent("邮箱的验证码为："+verifyCode+"</br>"+"请尽快完成注册");   
	        //这个类主要来发送邮件  
	     SimpleMailSender sms = new SimpleMailSender();  
//	         sms.sendTextMail(mailInfo);//发送文体格式   
	         sms.sendHtmlMail(mailInfo);//发送html格式  
		
	}
}
