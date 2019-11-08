package com.nagarro.adminPanel.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.nagarro.adminPanel.model.CustomerDetails;

@Repository
public class UserRegistrationDaoImpl implements UserRegistrationDao {

//	@Autowired
//	SessionDao sessionDao;

	private Configuration configuration;
	private SessionFactory sessionFactory;

	public UserRegistrationDaoImpl() {
		configuration = new Configuration().configure();
		sessionFactory = configuration.buildSessionFactory();
	}

	public String registerUserInDB(CustomerDetails userInformation) {

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
