package com.nagarro.adminPanel.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.adminPanel.dao.ValidateUserDao;
import com.nagarro.adminPanel.dto.LoginServicesDTO;
import com.nagarro.adminPanel.model.CustomerDetails;

@Service
public class ValidateUserServicesImpl implements ValidateUserServices {

	final static Logger LOG = Logger.getLogger(ValidateUserServicesImpl.class);

	LoginServicesDTO customerLoginInformation = new LoginServicesDTO();

	@Autowired
	ValidateUserDao validateUserDao;

	public LoginServicesDTO validateUser(String customerID) {
		CustomerDetails customerInformation = validateUserDao.validateUser(customerID);

		LOG.info("Inside service for validating the user in the database.");

		if (customerInformation == null)
			return null;

		customerLoginInformation.setCustomerID(customerInformation.getCustomerID());
		customerLoginInformation.setCustomerName(customerInformation.getCustomerName());
		customerLoginInformation.setAccountBalance(customerInformation.getAccountBalance());

		return customerLoginInformation;
	}
}