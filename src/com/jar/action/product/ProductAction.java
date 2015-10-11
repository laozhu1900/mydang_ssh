package com.jar.action.product;

import java.util.List;

import com.jar.domain.Book;
import com.jar.service.ProductService;
import com.jar.util.PageBean;
import com.opensymphony.xwork2.ActionSupport;

public class ProductAction extends ActionSupport {

	// 设置p属性在product.action中转发的页面中中被直接获取
	// private List<Product> plist;

	private ProductService productService;

	private PageBean pageBean;

	private List<Book> listBook;// 用于储存pageBean当中被封装的User信息

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}


	public List<Book> getListBook() {
		return listBook;
	}

	public void setListBook(List<Book> listBook) {
		this.listBook = listBook;
	}


	private int page = 1; // 表示从网页中返回的当前页的值 默认为1 表示默认显示第一页内容

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
		pageBean = productService.queryForPage(4, page);// 获取封装了分页信息和数据的pageBean
		listBook = pageBean.getList(); // 获取数据
//		System.out.println(listBook.get(1).getAuthor());
		return SUCCESS;
	}

	// // 获得当前页
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
	// // 将product表和book表中的所有的数据集合赋值给p
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
