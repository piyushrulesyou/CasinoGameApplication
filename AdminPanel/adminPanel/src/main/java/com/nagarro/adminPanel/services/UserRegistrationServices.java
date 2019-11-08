package com.nagarro.adminPanel.services;

import com.nagarro.adminPanel.model.CustomerDetails;

public interface UserRegistrationServices {

	/**
	 * This method adds new customer by calling CustomerDao's addCustomer method
	 * after the customer is validated successfully.
	 * 
	 * @param userInformation
	 * @return
	 */
	public String registerUser(CustomerDetails userInformation);

}