package com.jar.dao.impl;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.jar.dao.UserDao;
import com.jar.domain.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao,
		HibernateCallback {

	public void save(User user) throws Exception {

		this.getHibernateTemplate().save(user);

	}

	
	public User findByEmail(final String email) throws Exception {

		return (User) this.getHibernateTemplate().execute(
				new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session
								.createQuery("from User where email=?");
						query.setString(0, email);
						return query.uniqueResult();
					}
				});
	}

	public User findByNickname(final String nickname) throws Exception {

		return (User) this.getHibernateTemplate().execute(
				new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session
								.createQuery("from User where nickname=?");

						query.setString(0, nickname);

						return query.uniqueResult();
					}
				});
	}

	
	public User login(final String email, final String password) {

		return (User) this.getHibernateTemplate().execute(new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				
				Query query = session.createQuery("from User where email=? and password=?");
				
				query.setString(0, email);
				query.setString(1, password);
				
				return query.uniqueResult();
			}
		});
	}

	
	
	@Override
	public void modfiy_is_email_verify(User user) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void modfiyTimeIp(User user) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Object doInHibernate(Session arg0) throws HibernateException,
			SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
