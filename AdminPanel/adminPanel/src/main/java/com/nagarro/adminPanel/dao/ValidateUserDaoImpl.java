package com.nagarro.adminPanel.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.nagarro.adminPanel.dto.LoginServicesDTO;
import com.nagarro.adminPanel.model.CustomerDetails;

@Repository
public class ValidateUserDaoImpl implements ValidateUserDao {

	private Configuration con;
	private SessionFactory sessionFactory;

	LoginServicesDTO customerLoginInformation = new LoginServicesDTO();

	public ValidateUserDaoImpl() {
		con = new Configuration().configure();
		sessionFactory = con.buildSessionFactory();
	}

	@Override
	public LoginServicesDTO validateUser(String customerID) {
		try {

			Session session = sessionFactory.openSession();

			CustomerDetails userInformation = session.get(CustomerDetails.class, customerID);

			session.close();

			customerLoginInformation.setCustomerName(userInformation.getCustomerName());
			customerLoginInformation.setAccountBalance(userInformation.getAccountBalance());

			return customerLoginInformation;

		} catch (NullPointerException exception) {
			return null;
		}

	}
}
