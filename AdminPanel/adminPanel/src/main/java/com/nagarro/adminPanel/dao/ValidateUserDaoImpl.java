package com.nagarro.adminPanel.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.nagarro.adminPanel.model.CustomerDetails;

@Repository
public class ValidateUserDaoImpl implements ValidateUserDao {

	final static Logger LOG = Logger.getLogger(ValidateUserDaoImpl.class);

	private Configuration con;
	private SessionFactory sessionFactory;

	public ValidateUserDaoImpl() {
		LOG.info("Configuring hibernate and building session factory. ");

		con = new Configuration().configure();
		sessionFactory = con.buildSessionFactory();

		LOG.info("Configuration and building Succesfull");
	}

	public CustomerDetails validateUser(String customerID) {
		try {

			LOG.info("Inside method for validating the user in the DB");

			Session session = sessionFactory.openSession();

			CustomerDetails userInformation = session.get(CustomerDetails.class, customerID);

			session.close();

			return userInformation;

		} catch (NullPointerException exception) {
			return null;
		}

	}
}
