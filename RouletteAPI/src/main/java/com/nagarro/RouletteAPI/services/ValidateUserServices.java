package com.nagarro.RouletteAPI.services;

import com.sun.jersey.api.client.WebResource;

public interface ValidateUserServices {

	/**
	 * This method accepts customer ID in parameter and requests Administrator
	 * Application for customer login.
	 * 
	 * @param customerId Unique ID of customer
	 * @return LoginResponse that has success property that determines whether login
	 *         was successful or not.
	 */

	public WebResource validateUserAndGetUserDetails(String customerID);

}
