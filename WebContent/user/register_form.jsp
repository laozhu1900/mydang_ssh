<%@page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>用户注册 - 当当网</title>
<link href="../css/login.css" rel="stylesheet" type="text/css" />
<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function ajaxFunction() {
		var xmlHttp;
		try { // Firefox, Opera 8.0+, Safari
			xmlHttp = new XMLHttpRequest();
		} catch (e) {
			try {// Internet Explorer
				xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				try {
					xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
				} catch (e) {
				
				}
			}
		}

		
		return xmlHttp;
	}
	function check_email() {

		/* email检查ajax */
		var email = document.getElementById("txtEmail").value;
		var xhr = ajaxFunction();
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4) {
				if (xhr.status == 200) {
					var data = xhr.responseText; //获取文本
					if (data == "1") {
						document.getElementById("email.info").innerHTML = "<font color='red'>该邮箱已经被注册</font>";
						return false;
					}
					if (data == "3") {
						document.getElementById("email.info").innerHTML = "<font color='red'>邮箱不能为空</font>";
						return false;
					} 
					if(data =="4"){
						document.getElementById("email.info").innerHTML = "<font color='red'>这不是一个正确的邮箱</font>";
						return false;
					}else {
						document.getElementById("email.info").innerHTML = "<font color='green'>恭喜，该邮箱可以使用</font>";
						return true;
					}
				}
			}
		}
		xhr.open("get", "check_email.action?email=" + email, true);
		xhr.setRequestHeader("Content-type",
				"application/x-www-form-urlencoded");
		xhr.send();

	}
	
	function check_nickname() {

		var nickname = document.getElementById("txtNickName").value;
		var xhr = ajaxFunction();
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4) {
				if (xhr.status == 200) {
					var data = xhr.responseText; //获取文本
					if (data == "1") {
						document.getElementById("name.info").innerHTML = "<font color='red'>昵称不能为空</font>";
						return false;
					}
					if (data == "2") {
						document.getElementById("name.info").innerHTML = "<font color='red'>昵称格式不对，您的昵称可以由小写英文字母、中文、数字组成，长度4－20个字符，一个汉字为两个字符。</font>";
						return false;
					} 
					if(data =="4"){
						document.getElementById("name.info").innerHTML = "<font color='red'>改昵称被占用</font>";
						return false;
					}else {
						document.getElementById("name.info").innerHTML = "<font color='green'>恭喜，该昵称可以使用</font>";
						return true;
					}
				}
			}
		}
		xhr.open("get", "check_nickname.action?nickname=" + nickname, true);
		xhr.setRequestHeader("Content-type",
				"application/x-www-form-urlencoded");
		xhr.send();

	}
	
	
	function check_password() {

		var password = document.getElementById("txtPassword").value;
		var xhr = ajaxFunction();
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4) {
				if (xhr.status == 200) {
					var data = xhr.responseText; //获取文本
					if (data == "1") {
						document.getElementById("password.info").innerHTML = "<font color='red'>密码不能为空</font>";
						return false;
					}
					if (data == "2") {
						document.getElementById("password.info").innerHTML = "<font color='red'>密码格式不对，可以由大小写英文字母，数字组成，长度6－20个字符</font>";
						return false;
					} if(data == "3") {
						document.getElementById("password.info").innerHTML = "<font color='green'>恭喜，该密码可以使用</font>";
						return true;
					}
				}
			}
		}
		xhr.open("get", "check_password.action?password=" + password, true);
		xhr.setRequestHeader("Content-type",
				"application/x-www-form-urlencoded");
		xhr.send();

	}
	
	
	
	function check_password1() {

		var password1 = document.getElementById("txtRepeatPass").value;
		var password = document.getElementById("txtPassword").value;
		var xhr = ajaxFunction();
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4) {
				if (xhr.status == 200) {
					var data = xhr.responseText; //获取文本
					if (data == "1") {
						document.getElementById("password1.info").innerHTML = "<font color='red'>两次密码不一致</font>";
						return false;
					}
					if (data == "2") {
						document.getElementById("password1.info").innerHTML = "<font color='red'>密码不能为空</font>";
						return false;
					} if(data == "3") {
						document.getElementById("password1.info").innerHTML = "<font color='green'>两次密码一致</font>";
						return true;
					}
				}
			}
		}
		xhr.open("get", "check_password1.action?password1=" + password1+"&&password=" + password, true);
		xhr.setRequestHeader("Content-type",
				"application/x-www-form-urlencoded");
		xhr.send();

	}
	
	
	function check_ImgCode() {

		var ImgCode = document.getElementById("txtVerifyCode").value;
		var xhr = ajaxFunction();
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4) {
				if (xhr.status == 200) {
					var data = xhr.responseText; //获取文本
					if (data == "1") {
						document.getElementById("number.info").innerHTML = "<font color='red'>验证码不能为空</font>";
						return false;
					}
					if (data == "2") {
						document.getElementById("number.info").innerHTML = "<font color='red'>输入的验证码错误</font>";
						return false;
					} if(data == "3") {
						document.getElementById("number.info").innerHTML = "<font color='green'>验证码输入正确</font>";
						return true;
					}
				}
			}
		}
		xhr.open("get", "check_ImgCode.action?number=" + ImgCode, true);
		xhr.setRequestHeader("Content-type",
				"application/x-www-form-urlencoded");
		xhr.send();

	}
	
	
</script>

</head>
<body>
	<%@include file="../common/head1.jsp"%>
	<div class="login_step">
		注册步骤: <span class="red_bold">1.填写信息</span> > 2.验证邮箱 > 3.注册成功
	</div>
	<div class="fill_message">
		<form name="ctl00" method="post" action="register.action" id="f">
			<h2>以下均为必填项</h2>
			<table class="tab_login">
				<tr>
					<td valign="top" class="w1">请填写您的Email地址：</td>
					<td><input name="email" type="text" id="txtEmail"
						class="text_input" onblur="check_email()" />
						<div class="text_left" id="emailValidMsg">

							<span id="email.info" style="color: black"><p>请填写有效的Email地址，在下一步中您将用此邮箱接收验证邮件。</p></span>
						</div></td>
				</tr>
				<tr>
					<td valign="top" class="w1">设置您在当当网的昵称：</td>
					<td><input name="nickname" type="text" id="txtNickName"
						class="text_input" onblur="check_nickname()" />
						<div class="text_left" id="nickNameValidMsg">

							<span id="name.info" style="color: black"><p>您的昵称可以由小写英文字母、中文、数字组成，
								<p>长度4－20个字符，一个汉字为两个字符。</p></span>
						</div></td>
				</tr>
				<tr>
					<td valign="top" class="w1">设置密码：</td>
					<td><input name="password" type="password" id="txtPassword"
						class="text_input" onblur="check_password()" />
						<div class="text_left" id="passwordValidMsg">

							<span id="password.info" style="color: black"><p>您的密码可以由大小写英文字母、数字组成，长度6－20位。</p></span>
						</div></td>
				</tr>
				<tr>
					<td valign="top" class="w1">再次输入您设置的密码：</td>
					<td><input name="password1" type="password" id="txtRepeatPass"
						class="text_input" onblur="check_password1()" />
						<div class="text_left" id="repeatPassValidMsg">
							<span id="password1.info" style="color: red"></span>
						</div></td>
				</tr>
				<tr>
					<td valign="top" class="w1">验证码：</td>
					<td><img class="yzm_img" id='imgVcode' src="ImgCode.action"  onclick="this.src=this.src + '?' + new Date().getTime()"/> 
					<input
						name="number" type="text" id="txtVerifyCode" class="yzm_input" onblur="check_ImgCode()" />
						<div class="text_left t1">
							<p class="t1">
								<span id="vcodeValidMsg"></span> <span id="number.info"
									style="color: black">请输入图片中的四个字母。</span> <a href="javascript:void(0)"  onclick="document.getElementById('imgVcode').src=document.getElementById('imgVcode').src + '?' + new Date().getTime()">看不清楚？换个图片</a>
							</p>
						</div></td>
				</tr>
			</table>

			<div class="login_in">

				<input id="btnClientRegister" class="button_1" name="submit"
					type="submit" value="注 册" />
			</div>
		</form>
	</div>
	<%@include file="../common/foot1.jsp"%>
</body>
</html>

