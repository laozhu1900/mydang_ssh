<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="../css/book_head090107.css" rel="stylesheet" type="text/css" />
<div class="head_container">
	<div class="head_welcome">
		<div class="head_welcome_right">
			<span class="head_welcome_text"> </span>
			<span class="head_welcome_text"> <span class="little_n">
					| <a href="#" name="mydangdang" class="head_black12a">我的当当</a> | <a
					href="#" name="helpcenter" class="head_black12a" target="_blank">帮助</a>
					| </span> </span>
			<div class="cart gray4012">
				<a href="../cart/cart_list.jsp">购物车</a>
			</div>
		</div>
		<span class="head_toutext" id="logininfo">
		<b>
			<c:if test="${not empty user.nickname}">
				您好,${user.nickname}
			</c:if>
			
			<c:if test="${ empty user.nickname}">
				您好,欢迎来到当当网
			</c:if>
			
		</b>
		<c:if test="${not empty user }">
		[&nbsp;<a href="logout.action" class="b">登出</a>&nbsp;]
		</c:if>
		<c:if test="${empty user }">
		[&nbsp;<a href="../user/login_form.jsp" class="b">登录</a>|<a
			href="../user/register_form.jsp" class="b">注册</a>&nbsp;]
		</c:if>
		</span>
	</div>
	<div class="head_head_list">
		<div class="head_head_list_left">
			<span class="head_logo"><a href="#" name="backtobook"><img
						src="../images/booksaleimg/book_logo.gif" /> </a> </span>
		</div>
		<div class="head_head_list_right">

			<div class="head_head_list_right_b">
			</div>
		</div>
	</div>
	<div class="head_search_div">

	</div>
	<div class="head_search_bg"></div>
</div>
