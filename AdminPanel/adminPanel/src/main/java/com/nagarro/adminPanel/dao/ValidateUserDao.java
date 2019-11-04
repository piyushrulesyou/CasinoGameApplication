package com.nagarro.adminPanel.dao;

import com.nagarro.adminPanel.model.CustomerDetails;

public interface ValidateUserDao {

	public CustomerDetails validateUser(String customerID);

}