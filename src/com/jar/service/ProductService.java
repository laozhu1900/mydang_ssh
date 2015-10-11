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
	 * ��ҳ��ѯ     
	 * @param pageSize  ÿҳ��ʾ���ټ�¼   
	 * @param currentPage ��ǰҳ   
	 * @return ��װ�˷�ҳ��Ϣ��bean   
	 */    
	public PageBean queryForPage(int pageSize,int page);   
	
	public Book getById(int id);
}
