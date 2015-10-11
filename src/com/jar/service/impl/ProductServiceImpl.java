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
		final String hql = "from Book b order by b.id"; // ��ѯ���
		int allRow = productDao.getAllRowCount(hql); // �ܼ�¼��
		int totalPage = PageBean.countTatalPage(pageSize, allRow); // ��ҳ��
		final int offset = PageBean.countOffset(pageSize, page); // ��ǰҳ��ʼ��¼
		final int length = pageSize; // ÿҳ��¼��
		final int currentPage = PageBean.countCurrentPage(page); // ��ǰҳ
		List list = productDao.queryForPage(hql, offset, length); //
		// �ѷ�ҳ��Ϣ���浽Bean����
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
