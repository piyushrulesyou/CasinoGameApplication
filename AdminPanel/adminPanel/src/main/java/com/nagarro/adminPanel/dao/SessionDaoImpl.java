package com.nagarro.adminPanel.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

@Repository
public class SessionDaoImpl implements SessionDao {

	private Configuration configuration = new Configuration().configure();
	private SessionFactory sessionFactory = configuration.buildSessionFactory();
	private Session session;

	public Session getSession() {
		return session;
	}

	public void begin() {
		session = sessionFactory.openSession();
		session.beginTransaction();
	}

	public void commit() {
		session.getTransaction().commit();
	}

	public void close() {
		session.close();
	}

	public void rollback() {
		session.getTransaction().rollback();
	}

}
