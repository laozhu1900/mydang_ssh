package com.jar.service.impl;

import java.util.List;

import com.jar.dao.ProductDao;
import com.jar.domain.Book;
import com.jar.domain.Product;
import com.jar.service.ProductService;
import com.jar.util.PageBean;

public class ProductServiceImpl implements ProductService {

	

	private ProductDao productDao;

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public PageBean queryForPage(int pageSize, int page) {
		final String hql = "from Book b order by b.id"; // 查询语句
		int allRow = productDao.getAllRowCount(hql); // 总记录数
		int totalPage = PageBean.countTatalPage(pageSize, allRow); // 总页数
		final int offset = PageBean.countOffset(pageSize, page); // 当前页开始记录
		final int length = pageSize; // 每页记录数
		final int currentPage = PageBean.countCurrentPage(page); // 当前页
		List list = productDao.queryForPage(hql, offset, length); //
		// 把分页信息保存到Bean当中
		PageBean pageBean = new PageBean();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(allRow);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		pageBean.init();
		return pageBean;
	}

	
	
	

	public Book getById(int id) {
		return productDao.getById(id);
	}
	
	
	
	
	// public void setProductDao(ProductDao productDao) {
	// this.productDao = productDao;
	// }
	//
	// public List<Product> getAll() {
	//
	// return productDao.getAll();
	// }
	//
	// public List<Product> getAllByPage(int page, int row) {
	// return productDao.getAllByPage(page, row);
	// }
	//
	// public long getTotalRecord() {
	// return productDao.getTotalRecord();
	// }
	//

}
