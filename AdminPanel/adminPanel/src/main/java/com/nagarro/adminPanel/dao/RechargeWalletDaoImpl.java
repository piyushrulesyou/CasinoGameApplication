package com.nagarro.adminPanel.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.nagarro.adminPanel.model.CustomerDetails;

@Repository
public class RechargeWalletDaoImpl implements RechargeWalletDao {

	final static Logger LOG = Logger.getLogger(RechargeWalletDaoImpl.class);

	private Configuration con;
	private SessionFactory sessionFactory;

	public RechargeWalletDaoImpl() {
		LOG.info("Configuring hibernate and building session factory. ");

		con = new Configuration().configure();
		sessionFactory = con.buildSessionFactory();

		LOG.info("Configuration and building Succesfull");
	}

	public void rechargeInDB(String customerID, double rechargeAmount) {

		LOG.info("Inside method to recharge the customer with id " + customerID);

		Session session = sessionFactory.openSession();

		session.beginTransaction();

		CustomerDetails customer = session.get(CustomerDetails.class, customerID);

		customer.setAccountBalance(customer.getAccountBalance() + rechargeAmount);

		System.out.println(customer.getAccountBalance() + "hu");

		session.update(customer);
		session.getTransaction().commit();
		session.close();

	}

}
