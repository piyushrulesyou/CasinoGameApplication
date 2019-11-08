package com.nagarro.adminPanel.dao;

import com.nagarro.adminPanel.model.CustomerDetails;

public interface FetchAndUpdateCustomerDao {

	/**
	 * /** This method blocks the balance of customer that matches with customerId
	 * received as parameter. In case the customer do not has sufficient amount,
	 * false is returned.
	 * 
	 * @param id     Unique ID of customer
	 * @param amount Amount to be blocked.
	 * @return True if balance is blocked successfully and false if not
	 */
	public CustomerDetails fetchCustomerDetails(String customerID);

	/**
	 * /** This method adjusts the balance of customer that matches with customerId
	 * received as parameter.
	 * 
	 * @param id           Unique ID of customer
	 * @param adjustAmount Amount to be adjusted. Can be positive or negative.
	 * @return True if balance is adjusted successfully and false if not
	 */
	public void updateCustomerDetails(CustomerDetails userInformation);

}