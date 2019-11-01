package com.nagarro.adminPanel.dao;

import com.nagarro.adminPanel.model.CustomerDetails;

public interface UserRegistrationDao {

	public String registerUserInDB(CustomerDetails userInformation);

}