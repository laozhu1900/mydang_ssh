package com.jar.mail;

import com.jar.util.UserUtil;

public class MailSend {
	public static void main(String[] args){  
        //�������Ҫ�������ʼ�  
     MailSenderInfo mailInfo = new MailSenderInfo();   
     mailInfo.setMailServerHost("smtp.163.com");   
     mailInfo.setMailServerPort("25");   
     mailInfo.setValidate(true);   
     mailInfo.setUserName("zhuzw0929@163.com");   
     mailInfo.setPassword("930929zzw");//������������   
     mailInfo.setFromAddress("zhuzw0929@163.com");   
     mailInfo.setToAddress("1206953863@qq.com");   
     mailInfo.setSubject("�������û�ע��������֤");   
     mailInfo.setContent("�������֤��Ϊ��"+new UserUtil().createEmailVerifyCode()+"</br>"+"�뾡�����ע��");   
        //�������Ҫ�������ʼ�  
     SimpleMailSender sms = new SimpleMailSender();  
//         sms.sendTextMail(mailInfo);//���������ʽ   
         sms.sendHtmlMail(mailInfo);//����html��ʽ  
   }  
	
	public void send(String email,String verifyCode){
		 MailSenderInfo mailInfo = new MailSenderInfo();   
	     mailInfo.setMailServerHost("smtp.163.com");   
	     mailInfo.setMailServerPort("25");   
	     mailInfo.setValidate(true);   
	     mailInfo.setUserName("zhuzw0929@163.com");   
	     mailInfo.setPassword("930929zzw");//������������   
	     mailInfo.setFromAddress("zhuzw0929@163.com");   
	     mailInfo.setToAddress(email);   
	     mailInfo.setSubject("�������û�ע��������֤");   
	     mailInfo.setContent("�������֤��Ϊ��"+verifyCode+"</br>"+"�뾡�����ע��");   
	        //�������Ҫ�������ʼ�  
	     SimpleMailSender sms = new SimpleMailSender();  
//	         sms.sendTextMail(mailInfo);//���������ʽ   
	         sms.sendHtmlMail(mailInfo);//����html��ʽ  
		
	}
}
