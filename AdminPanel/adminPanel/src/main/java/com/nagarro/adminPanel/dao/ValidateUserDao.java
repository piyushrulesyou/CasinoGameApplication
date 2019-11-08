package com.nagarro.adminPanel.dao;

import com.nagarro.adminPanel.model.CustomerDetails;

public interface ValidateUserDao {

	/**
	 * This method is used to confirm the identity of the customer before the
	 * customer proceeds to play.
	 * 
	 * @param customerID
	 * @return
	 */
	public CustomerDetails validateUser(String customerID);

}