package com.jar.dao;

import java.util.List;

import com.jar.domain.Book;
import com.jar.domain.Product;

public interface ProductDao {

//	List<Product> getAll(); 
//	
//	List<Product> getAllByPage(int page,int row); 
//	
//	long getTotalRecord();
	
	
	
	/**   
	 * ��ҳ��ѯ   
	 * @param hql  ��ѯ����   
	 * @param offset  ��ʼ��¼   
	 * @param length  һ�β�ѯ������¼   
	 * @return ��ѯ�ļ�¼����   
	 */    
	public List<Book> queryForPage(final String hql,final int offset,final int length);    
	/**   
	 * ��ѯ���еļ�¼��   
	 * @param hql ��ѯ����   
	 * @return �ܼ�¼��   
	 */    
	public int getAllRowCount(String hql);
	
	public Book getById(int id);
		
		
	
}
