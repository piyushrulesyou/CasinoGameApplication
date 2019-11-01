package com.nagarro.adminPanel.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.nagarro.adminPanel.model.CustomerDetails;

@Repository
public class RechargeWalletDaoImpl implements RechargeWalletDao {

	private Configuration con;
	private SessionFactory sessionFactory;

	public RechargeWalletDaoImpl() {
		con = new Configuration().configure();
		sessionFactory = con.buildSessionFactory();
	}

	public void rechargeInDB(String customerID, double rechargeAmount) {

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
