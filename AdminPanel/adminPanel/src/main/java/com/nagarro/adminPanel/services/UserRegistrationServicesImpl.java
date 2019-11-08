package com.nagarro.adminPanel.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.adminPanel.dao.UserRegistrationDao;
import com.nagarro.adminPanel.model.CustomerDetails;

@Service
public class UserRegistrationServicesImpl implements UserRegistrationServices {

	final static Logger LOG = Logger.getLogger(UserRegistrationServicesImpl.class);

	@Autowired
	UserRegistrationDao userRegistrationDao;

	public String registerUser(CustomerDetails userInformation) {

		LOG.info("Inside service for registering the new user in DB");

		String newCustomerID = userRegistrationDao.registerUserInDB(userInformation);

		return newCustomerID;
	}

}
