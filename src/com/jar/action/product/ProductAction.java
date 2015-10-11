package com.jar.action.product;

import java.util.List;

import com.jar.domain.Book;
import com.jar.service.ProductService;
import com.jar.util.PageBean;
import com.opensymphony.xwork2.ActionSupport;

public class ProductAction extends ActionSupport {

	// ����p������product.action��ת����ҳ�����б�ֱ�ӻ�ȡ
	// private List<Product> plist;

	private ProductService productService;

	private PageBean pageBean;

	private List<Book> listBook;// ���ڴ���pageBean���б���װ��User��Ϣ

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}


	public List<Book> getListBook() {
		return listBook;
	}

	public void setListBook(List<Book> listBook) {
		this.listBook = listBook;
	}


	private int page = 1; // ��ʾ����ҳ�з��صĵ�ǰҳ��ֵ Ĭ��Ϊ1 ��ʾĬ����ʾ��һҳ����

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public String getAllByPage() throws Exception {
		pageBean = productService.queryForPage(4, page);// ��ȡ��װ�˷�ҳ��Ϣ�����ݵ�pageBean
		listBook = pageBean.getList(); // ��ȡ����
//		System.out.println(listBook.get(1).getAuthor());
		return SUCCESS;
	}

	// // ��õ�ǰҳ
	// private int page = 1;
	//
	// private int row = 4;
	//
	// private long totalRecord;
	//
	// private int totalPage;
	//
	// public int getRow() {
	// return row;
	// }
	//
	// public void setRow(int row) {
	// this.row = row;
	// }
	//
	// public long getTotalRecord() {
	// return totalRecord;
	// }
	//
	// public void setTotalRecord(int totalRecord) {
	// this.totalRecord = totalRecord;
	// }
	//
	// public int getTotalPage() {
	// return totalPage;
	// }
	//
	// public void setTotalPage(int totalPage) {
	// this.totalPage = totalPage;
	// }
	//
	// public int getPage() {
	// return page;
	// }
	//
	// public void setPage(int page) {
	// this.page = page;
	// }
	//
	// public List<Product> getPlist() {
	// return plist;
	// }
	//
	// public void setPlist(List<Product> plist) {
	// this.plist = plist;
	// }
	//
	// public String getAllByPage() {
	// // ��product���book���е����е����ݼ��ϸ�ֵ��p
	//
	// plist = productService.getAllByPage(page, row);
	// totalRecord = productService.getTotalRecord();
	//
	// if (totalPage % row == 0) {
	// totalPage = (int) (totalRecord / row);
	// } else {
	// totalPage = (int) (totalRecord / row + 1);
	// }
	//
	// return SUCCESS;
	// }

}
