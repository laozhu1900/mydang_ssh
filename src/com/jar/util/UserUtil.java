package com.jar.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class UserUtil {

	public String createEmailVerifyCode() {

		// 生成四位随机数
		String EmailVerifyCode = String
				.valueOf(System.currentTimeMillis() % 9000 + 1000);

		return EmailVerifyCode;

	}

	public long getCurrentTime() {

		String currentTime = new SimpleDateFormat("yyyyMMddHHmmssSSS")
				.format(new Date());

		return Long.parseLong(currentTime);
	}

	public String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	public static void main(String[] args) {

	}

}
