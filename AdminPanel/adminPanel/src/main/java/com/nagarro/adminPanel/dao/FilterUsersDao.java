package com.nagarro.adminPanel.dao;

import java.util.List;

import com.nagarro.adminPanel.model.CustomerDetails;

public interface FilterUsersDao {

	/**
	 * This method filters the users on the basis of values received from any of the
	 * three variables.
	 * 
	 * @param filterName
	 * @param filterContact
	 * @param filterEMail
	 * @return The list of resultant customers.
	 */
	public List<CustomerDetails> filterList(String filterName, String filterContact, String filterEMail);

}