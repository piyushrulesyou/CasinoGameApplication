package com.nagarro.adminPanel.services;

import java.util.List;

import com.nagarro.adminPanel.model.CustomerDetails;

public interface UserListServices {

	/**
	 * This method gets the list of customer by calling CustomerDao's getCustomer
	 * method.
	 * 
	 * @return The list of customers.
	 */
	List<CustomerDetails> fetchAllUsers();

}