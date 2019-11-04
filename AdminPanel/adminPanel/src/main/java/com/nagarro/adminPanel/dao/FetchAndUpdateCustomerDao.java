package com.nagarro.adminPanel.dao;

import com.nagarro.adminPanel.model.CustomerDetails;

public interface FetchAndUpdateCustomerDao {

	public CustomerDetails fetchCustomerDetails(String customerID);

	public void updateCustomerDetails(CustomerDetails userInformation);

}