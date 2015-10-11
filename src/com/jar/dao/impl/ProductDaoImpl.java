package com.jar.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.jar.dao.ProductDao;
import com.jar.domain.Book;
import com.jar.domain.Product;

public class ProductDaoImpl extends HibernateDaoSupport implements ProductDao,
		HibernateCallback {

	@Override
	public Object doInHibernate(Session arg0) throws HibernateException,
			SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/**   
	 * ��ҳ��ѯ   
	 * @param hql  ��ѯ����   
	 * @param offset  ��ʼ��¼   
	 * @param length  һ�β�ѯ������¼   
	 * @return ��ѯ�ļ�¼����   
	 */    
	public List<Book> queryForPage(String hql, int offset, int length) {
		Session session = this.getSession();    
		Query q = session.createQuery(hql);    
		q.setFirstResult(offset);    
		q.setMaxResults(length);    
		List<Book> list = q.list();    
		System.out.println(list.size());    
		session.close();    
		return list;    
	}


	/**   
	 * ��ѯ���еļ�¼��   
	 * @param hql ��ѯ����   
	 * @return �ܼ�¼��   
	 */
	public int getAllRowCount(String hql) {
		return this.getHibernateTemplate().find(hql).size();    
	}
 
	
	
	//���ݲ�Ʒ���ƽ��в�ѯ
	public Book getById(final int id) {
		
		
		return (Book) this.getHibernateTemplate().execute(new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				
				
				Query query = session
						.createQuery("from Book where id=?");
				query.setLong(0, id);
				
				return query.uniqueResult();
				
			}
		});
	}

	
	
	
	
//	@Override
//	public Object doInHibernate(Session arg0) throws HibernateException,
//			SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	//��ѯ����ͼ��
//	public List<Product> getAll() {
//
//		@SuppressWarnings("unchecked")
//		List<Product> list = (List<Product>) this.getHibernateTemplate()
//				.execute(new HibernateCallback() {
//
//					public Object doInHibernate(Session session)
//							throws HibernateException, SQLException {
//						String hql = "from Product";
//						Query query = session.createQuery(hql);
//
//						return query.list();
//					}
//				});
//
//		return list;
//	}
//
//	public List<Product> getAllByPage(final int page, final int row) {
//
//		@SuppressWarnings("unchecked")
//		List<Product> list = (List<Product>) this.getHibernateTemplate()
//				.execute(new HibernateCallback() {
//
//					public Object doInHibernate(Session session)
//							throws HibernateException, SQLException {
//						String hql = "from Product limit "+page+","+row;
//						Query query = session.createQuery(hql);
//						
//						return query.list();
//					}
//				});
//
//		return list;
//	}
//
//	@Override
//	public long getTotalRecord() {
//		
//		return (long) this.getHibernateTemplate().execute(new HibernateCallback() {
//			
//			@Override
//			public Object doInHibernate(Session session) throws HibernateException,
//					SQLException {
//				String hql = "select count(*) from Product";
//				Query query = session.createQuery(hql);
//				return (long)query.uniqueResult();
//			}
//		});
//	}
	
	
	
	

}
