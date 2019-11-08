package com.nagarro.adminPanel.services;

import com.nagarro.adminPanel.dto.LoginServicesDTO;

public interface ValidateUserServices {

	/**
	 * This method accepts customer details in parameters, validate it for age > 18
	 * and returns a List of string with errors. In case the list is empty, then the
	 * customer is validated successfully.
	 * 
	 * @param customerID
	 * @return Details of the validated customer if ID is valid.
	 */
	public LoginServicesDTO validateUser(String customerID);

}