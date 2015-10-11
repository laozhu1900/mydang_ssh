package com.jar.service;

import java.util.List;

import com.jar.domain.Book;
import com.jar.domain.Product;
import com.jar.util.PageBean;

public interface ProductService {

//	List<Product> getAll();
//	
//	List<Product> getAllByPage(int page,int row);
//
//	long getTotalRecord();
	
	/**   
	 * 分页查询     
	 * @param pageSize  每页显示多少记录   
	 * @param currentPage 当前页   
	 * @return 封装了分页信息的bean   
	 */    
	public PageBean queryForPage(int pageSize,int page);   
	
	public Book getById(int id);
}
