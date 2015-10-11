package com.jar.domain;

import java.util.ArrayList;
import java.util.List;

import com.jar.service.ProductService;

public class Cart {

	private ProductService productService;

	List<CartItem> items = new ArrayList<CartItem>();
	
	private double totalprice;

	private double saveprice ;
	
	public double getSaveprice() {

		double price = 0.0;

		for (CartItem item : items) {
			price = (item.getBook().getFixedPrice() - item.getBook()
					.getDangPrice()) * item.getQty() + price;
		}

		this.saveprice = price;
		return saveprice;
	}

	public void setSaveprice(double saveprice) {
		this.saveprice = saveprice;
	}

	public double getTotalprice() {

		double price = 0.0;
		
		for (CartItem item : items) {
			price = item.getBook().getDangPrice() * item.getQty() + price;
		}
		
		this.totalprice = price;
		return totalprice;
	}

	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}

	

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public boolean add(CartItem item) {
		
		boolean flag = true;
		
		for (CartItem c : items) {
			if (c.getBook().getId() == item.getBook().getId()) {
				flag = false;
			}
		}
		
		if(flag){
			items.add(item);
		}
		
		return flag;
	
	}

	public List<CartItem> allList() {
		return items;
	}

	public void modify(long id, int qty) {
		for (CartItem item : items) {
			if (item.getBook().getId() == id) {
				item.setQty(qty);
				return;
			}
		}
	}

	public void delete(long id) {
		for (CartItem item : items) {
			if (item.getBook().getId() == id) {
				items.remove(item);
				return;
			}
		}

	}

	// public double totalPrice(){
	// double total=0.0;
	// for(CartItem item:items){
	// total+=item.getBook().getDangPrice()*item.getQty();
	// }
	// return total;
	// }
	
	public void clear() {
		for (CartItem item : items) {
			if (item != null) {
				boolean rs = items.removeAll(items);
				return;
			}
		}
	}

	public String store() {
		StringBuffer sb = new StringBuffer();
		if (items.size() == 0) {
			sb.append("0");
		} else {
			for (CartItem item : items) {
				sb.append(item.getBook().getId() + "," + item.getQty() + ";");
			}
		}
		return sb.toString();
	}

	public void load(String content) throws Exception {// 1,4;3,5;6,7
		if (content == null || content.equals("0")) {
			return;
		}
		String[] pcs = content.split(";");
		for (int i = 0; i < pcs.length; i++) {

			String pc = pcs[i];
			String[] strs = pc.split(",");
			int id = Integer.parseInt(strs[0]);// ��ÿ���ֺ�ĵ�һ������ת����id
			int qty = Integer.parseInt(strs[1]);

			Book b = productService.getById(id);// �ҵ�ԭ�ȹ��ﳵ�е���Ʒ
			CartItem item = new CartItem();// �½���Ʒ��Ŀ
			item.setBook(b);
			;// ���������Ʒ�������뵽��Ʒ��Ŀ��
			item.setQty(qty);// ���������Ʒ�������뵽��Ʒ��Ŀ��
			items.add(item);// ���ָ�����Ʒ��Ŀ���뵽���ﳵ��Ʒ��Ŀ������
		}
	}

}
