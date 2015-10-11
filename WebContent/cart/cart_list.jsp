<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>当当图书 – 全球最大的中文网上书店</title>
<link href="../css/book.css" rel="stylesheet" type="text/css" />
<link href="../css/second.css" rel="stylesheet" type="text/css" />
<link href="../css/secBook_Show.css" rel="stylesheet" type="text/css" />
<link href="../css/shopping_vehicle.css" rel="stylesheet"
	type="text/css" />
<style type="text/css">
	
	#notbuy{
		font-size:16px;
		text-align: center;
		padding: 10;
		
	}

</style>


<script type="text/javascript">
			   function strip(str){
			     //return str.replace(/(^\s*)|(\s*$)/g,"");
			     return str.replace(/\s+/g,"");
			   }
			   function f1(id,qty){
			      
			        if(strip(qty).length==0){
			        alert("必须输入数量！");
			        return;
			        }
			        var reg=/^[0-9]+$/;
			        if(!reg.test(strip(qty))){
			           alert("必须是数字！");
			           return;
			        }
			        location.href='<%=response.encodeURL("changeQty.action")%>?id='+id+'&qty='+strip(qty);
			        
			   }
</script>


</head>
<body>
	<br />
	<br />
	<div class="my_shopping">
		<img class="pic_shop" src="../images/pic_myshopping.gif" />

	</div>




	<div id="div_choice" class="choice_merch">

		<c:if test="${empty cart}">
			<p id="notbuy">您没有购买任何商品 <a href='../main/main.jsp'>
					继续挑选商品>></a></p>
		</c:if>
		<c:if test="${!empty cart}">
			<h2 id="cart_tips">您已选购以下商品</h2>
			<div class="choice_bord">
				<table class="tabl_buy" id="tbCartItemsNormal">
					<tr class="tabl_buy_title">
						<td class="buy_td_6"><span>&nbsp;</span></td>
						<td><span class="span_w1">商品名</span></td>
						<td class="buy_td_5"><span class="span_w2">市场价</span></td>
						<td class="buy_td_4"><span class="span_w3">当当价</span></td>
						<td class="buy_td_1"><span class="span_w2">数量</span></td>
						<td class="buy_td_2"><span>变更数量</span></td>
						<td class="buy_td_1"><span>删除</span></td>
					</tr>
					<tr class='objhide' over="no">
						<td colspan="8">&nbsp;</td>
					</tr>


					<!-- 购物列表开始 -->


	
					<c:forEach items="${sessionScope.cartItems }" var="c">

					<tr class='td_no_bord'>
						<td style='display: none'>9317290</td>
						<td class="buy_td_6"><span class="objhide"><img /> </span></td>
						<td><a href="#">${c.book.productName }</a></td>
						<td class="buy_td_5"><span class="c_gray">￥${c.book.fixedPrice}</span></td>
						<td class="buy_td_4">&nbsp;&nbsp; <span>￥${c.book.dangPrice}</span>
						</td>
						<td class="buy_td_1">&nbsp;&nbsp;${c.qty}</td>

						<td><input class="del_num" type="text" size="3" maxlength="4" />
							<a href="javascript:;" onclick="f1(${c.book.id },${c.qty })">更改</a></td>
						<td><a href="deleteItem.action?id=${c.book.id}">删除</a></td>
					</tr>

					</c:forEach>
					<!-- 购物列表结束 -->

				</table>
				<div class="choice_balance">
					<div class="select_merch">
						<a href='../main/main.jsp'> 继续挑选商品>></a>
					</div>

					<div class="total_balance">
						<div class="save_total">
							您共节省： <span class="c_red"> ￥<span id="total_economy">${cart.saveprice }</span>
							</span> <span id='total_vip_economy' class='objhide'> ( 其中享有优惠： <span
								class="c_red"> ￥<span id='span_vip_economy'>0.00</span>
							</span> )
							</span> <span style="font-size: 14px">|</span> <span class="t_add">商品金额总计：</span>
							<span class="c_red_b"> ￥<span id='total_account'>${cart.totalprice }</span>
							</span>
						</div>
						<div id="balance" class="balance">
						
						<c:if test="${not empty user }">
							<a name='checkout' href='../order/order_info.jsp'> <img
								src="../images/butt_balance.gif" alt="结算" border="0" title="结算" />
							</a>
						</c:if>
						
						<c:if test="${ empty user }">
							<a name='checkout' href='../user/login_form.jsp'> <img
								src="../images/butt_balance.gif" alt="结算" border="0" title="结算" />
							</a>
						</c:if>
						
						
						</div>
					</div>
				</div>
			</div>
		</c:if>
	</div>



	<!-- 用户删除恢复区 -->

	<!--
	<div id="divCartItemsRemoved" class="del_merch">
		<div class="del_title">您已删除以下商品，如果想重新购买，请点击“恢复”</div>
		<table class=tabl_del id=del_table>
			<tbody>


				<tr>
					<td width="58" class=buy_td_6>&nbsp;</td>
					<td width="365" class=t2><a href="#">Java基础</a></td>
					<td width="106" class=buy_td_5>￥56</td>
					<td width="134" class=buy_td_4><span>￥50</span></td>
					<td width="56" class=buy_td_1><a href="#">恢复</a></td>
					<td width="16" class=objhide>&nbsp;</td>
				</tr>



				<tr class=td_add_bord>
					<td colspan=8>&nbsp;</td>
				</tr>


			</tbody>
		</table>
		
	</div>
-->
	<br />
	<br />
	<br />
	<br />
	<!--页尾开始 -->
	<%@include file="../common/foot.jsp"%>
	<!--页尾结束 -->
</body>
</html>



