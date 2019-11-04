package com.nagarro.adminPanel.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.nagarro.adminPanel.model.CustomerDetails;

@Repository
public class FetchAndUpdateCustomerDaoImpl implements FetchAndUpdateCustomerDao {
	private Configuration con;
	private SessionFactory sessionFactory;

	public FetchAndUpdateCustomerDaoImpl() {
		con = new Configuration().configure();
		sessionFactory = con.buildSessionFactory();
	}

	public CustomerDetails fetchCustomerDetails(String customerID) {

		try {
			Session session = sessionFactory.openSession();
			CustomerDetails userInformation = session.get(CustomerDetails.class, customerID);
			session.close();
			return userInformation;
		} catch (NullPointerException exception) {
			return null;
		}
	}

	public void updateCustomerDetails(CustomerDetails userInformation) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(userInformation);
		session.getTransaction().commit();
		session.close();

	}

}
