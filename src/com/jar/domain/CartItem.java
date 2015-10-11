package com.jar.domain;

//某一件商品
public class CartItem {

	// 购物车中某一件商品的信息和数量
	private Book book;
	private int qty = 1;
	
	private double price;

	public double getPrice() {

		double p = 0.0;

		p = book.getDangPrice() * qty;

		this.price = p;

		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public CartItem() {

	}

	

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

}
