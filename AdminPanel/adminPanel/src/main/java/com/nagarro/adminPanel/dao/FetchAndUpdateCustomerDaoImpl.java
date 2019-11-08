package com.nagarro.adminPanel.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.nagarro.adminPanel.model.CustomerDetails;

@Repository
public class FetchAndUpdateCustomerDaoImpl implements FetchAndUpdateCustomerDao {
	private Configuration con;
	private SessionFactory sessionFactory;

	final static Logger LOG = Logger.getLogger(FetchAndUpdateCustomerDaoImpl.class);

	public FetchAndUpdateCustomerDaoImpl() {
		LOG.info("Configuring hibernate and building session factory. ");

		con = new Configuration().configure();
		sessionFactory = con.buildSessionFactory();

		LOG.info("Configuration and building Succesfull");
	}

	public CustomerDetails fetchCustomerDetails(String customerID) {

		LOG.info("Fetching the details of the customer" + customerID);

		try {
			Session session = sessionFactory.openSession();
			CustomerDetails userInformation = session.get(CustomerDetails.class, customerID);
			session.close();
			return userInformation;
		} catch (NullPointerException exception) {
			LOG.error("Error occured while fetching the customer detils " + exception);
			return null;
		}
	}

	public void updateCustomerDetails(CustomerDetails userInformation) {

		LOG.info("Fetching the details of the customer" + userInformation.getCustomerID());

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(userInformation);
		session.getTransaction().commit();
		session.close();

	}

}
