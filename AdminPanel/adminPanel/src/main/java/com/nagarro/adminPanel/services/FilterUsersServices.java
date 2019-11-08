package com.nagarro.adminPanel.services;

import java.util.List;

import com.nagarro.adminPanel.model.CustomerDetails;

public interface FilterUsersServices {

	/**
	 * This method filters the list of the customers based upon the input values.
	 * 
	 * @param filterName
	 * @param filterContact
	 * @param filterEMail
	 * @return The list of filtered customers.
	 * 
	 */
	public List<CustomerDetails> filterUsersList(String filterName, String filterContact, String filterEMail);

}