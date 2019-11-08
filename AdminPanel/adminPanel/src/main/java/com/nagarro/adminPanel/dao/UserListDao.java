package com.nagarro.adminPanel.dao;

import java.util.List;

import com.nagarro.adminPanel.model.CustomerDetails;

public interface UserListDao {

	/**
	 * This method retrieves customers from DB that matches with the filter received
	 * in parameters.
	 * 
	 * @return list of customers that matches with the filters
	 */
	List<CustomerDetails> fetchAllUsers();

}