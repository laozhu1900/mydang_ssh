package com.jar.domain;

//ĳһ����Ʒ
public class CartItem {

	// ���ﳵ��ĳһ����Ʒ����Ϣ������
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
