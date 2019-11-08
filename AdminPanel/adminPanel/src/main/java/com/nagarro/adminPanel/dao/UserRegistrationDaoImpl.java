package com.nagarro.adminPanel.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.nagarro.adminPanel.model.CustomerDetails;

@Repository
public class UserRegistrationDaoImpl implements UserRegistrationDao {

	final static Logger LOG = Logger.getLogger(UserRegistrationDaoImpl.class);

	private Configuration con;
	private SessionFactory sessionFactory;

	public UserRegistrationDaoImpl() {
		LOG.info("Configuring hibernate and building session factory. ");

		con = new Configuration().configure();
		sessionFactory = con.buildSessionFactory();

		LOG.info("Configuration and building Succesfull");
	}

	public String registerUserInDB(CustomerDetails userInformation) {

		LOG.info("Inside method for registering the user in the DB");

		String newCustomerID;

		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			newCustomerID = (String) session.save(userInformation);
			session.getTransaction().commit();
			session.close();

		} catch (Exception exception) {
			newCustomerID = null;
		}

		return newCustomerID;
	}

}
