package com.nagarro.adminPanel.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.adminPanel.dao.ValidateUserDao;
import com.nagarro.adminPanel.dto.LoginServicesDTO;

@Service
public class ValidateUserServicesImpl implements ValidateUserServices {

	LoginServicesDTO customerLoginInformation;
	
	@Autowired
	ValidateUserDao validateUserDao;

	@Override
	public LoginServicesDTO validateUser(String customerID) {
		LoginServicesDTO customerLoginInformation = validateUserDao.validateUser(customerID);
		
		return customerLoginInformation;
	}
}