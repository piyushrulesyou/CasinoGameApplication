package com.nagarro.adminPanel.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.adminPanel.dto.LoginServicesDTO;
import com.nagarro.adminPanel.services.ValidateUserServices;

/**
 * This class is used for validating the user before the user can play the
 * roulette game.
 * 
 * @author piyushagarwal01
 *
 */
@RestController
public class ValidateUserController {

	final static Logger LOG = Logger.getLogger(ValidateUserController.class);

	@Autowired
	ValidateUserServices validateUserServices;

	/**
	 * This method accepts GET request from Roulette API for /login and calls
	 * loginCustomer service for customerId received.
	 * 
	 * @param customerID The ID of the customer to be validated.
	 * @return The details of the customer.
	 */
	@GetMapping("/customerdetails/{customerID}")
	public LoginServicesDTO getCustomerDetails(@PathVariable String customerID) {

		LOG.info("Recieved GET request for /login for customerId : " + customerID);

		LoginServicesDTO detailsOfCustomer = validateUserServices.validateUser(customerID);
		return detailsOfCustomer;
	}
}
