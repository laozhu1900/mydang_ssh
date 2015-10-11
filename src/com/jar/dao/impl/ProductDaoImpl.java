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
	 * 分页查询   
	 * @param hql  查询条件   
	 * @param offset  开始记录   
	 * @param length  一次查询几条记录   
	 * @return 查询的记录集合   
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
	 * 查询所有的记录数   
	 * @param hql 查询条件   
	 * @return 总记录数   
	 */
	public int getAllRowCount(String hql) {
		return this.getHibernateTemplate().find(hql).size();    
	}
 
	
	
	//根据产品名称进行查询
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
//	//查询所有图书
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
