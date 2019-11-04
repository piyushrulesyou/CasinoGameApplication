package com.nagarro.adminPanel.dao;

import com.nagarro.adminPanel.model.CustomerDetails;

public interface BlockAmountDao {

	public CustomerDetails fetchCustomerDetails(String customerID);

	public void updateCustomerDetails(CustomerDetails userInformation);

}