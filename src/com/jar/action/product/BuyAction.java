package com.jar.action.product;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.jar.domain.Book;
import com.jar.domain.Cart;
import com.jar.domain.CartItem;
import com.jar.service.ProductService;
import com.jar.util.CookieUtil;
import com.opensymphony.xwork2.ActionSupport;



public class BuyAction extends ActionSupport{
	
	private ProductService productService;

	private int id;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	public String buy() throws Exception {

		HttpServletRequest request = ServletActionContext.getRequest();
		Book book = productService.getById(id);
		CartItem item = new CartItem();

		item.setBook(book);
		item.setQty(1);

	
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if (cart == null) {

			cart = new Cart();
			
			request.getSession().setAttribute("cart", cart);

		}
		// 若已经买过商品，则将当前的商品条目添加到购物车中
		boolean flag = cart.add(item);  //这个不惯怎么样都是true

		
		
		List<CartItem> cartItems = new ArrayList<CartItem>();
		
		cartItems = cart.allList();
		
		request.getSession().setAttribute("cartItems", cartItems);

		System.out.println(flag);
		
		
		
		if (!flag) {
			// 如果该商品已经在购物车中存在，则提示用户

			item.setQty(item.getQty()+1);
		
		} 

			return SUCCESS;

	}
}
