package com.nagarro.adminPanel.dao;

import com.nagarro.adminPanel.model.CustomerDetails;

public interface UserRegistrationDao {

	/**
	 * This method adds customer object to the DB.
	 * 
	 * @param customer Customer object to be added
	 * @return True if customer is added successfully to DB and false if not.
	 */
	public String registerUserInDB(CustomerDetails userInformation);

}