package com.jar.util;



import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**cookie工具类*/
public class CookieUtil {
         //缺省的应用名
	   private static String default_path="/mydang_ssh";
	     //cookie的生存时间
	   private static int default_age=365*24*3600;
	   
	   //添加cookie(名字，值，resp，时间)
	   public static void add(String name,String value,HttpServletResponse resp,int age) throws UnsupportedEncodingException{
		   Cookie c = new Cookie(name,URLEncoder.encode(value,"utf-8"));
		   c.setMaxAge(age);
		   c.setPath(default_path);
		   resp.addCookie(c);
	   }
	   //添加cookie,不可以手动设置生命时间
	   public static void add(String name,String value,HttpServletResponse resp) throws UnsupportedEncodingException{
		   Cookie c = new Cookie(name,URLEncoder.encode(value,"utf-8"));
		  add(name,value,resp,default_age);
	   }
	   
	   //根据name查找cookie
	   public static String find(String name,HttpServletRequest req) throws Exception{
		   String value=null;
		   Cookie[] cs=req.getCookies();
		   if(cs!=null){
			   for(Cookie c:cs){
				   if(c.getName().equals(name)){
					   value=URLDecoder.decode(c.getValue(),"utf-8");
				   }
			   }
		   }
		   return value;
	   }
	   //删除cookie
	   public static void delete(String name,HttpServletResponse response){
		   Cookie c = new Cookie(name,"");
		   c.setMaxAge(0);
		   c.setPath(default_path);
	   }
}
