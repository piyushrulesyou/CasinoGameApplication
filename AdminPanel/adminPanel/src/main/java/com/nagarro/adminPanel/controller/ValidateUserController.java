package com.nagarro.adminPanel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.adminPanel.dto.LoginServicesDTO;
import com.nagarro.adminPanel.services.ValidateUserServices;

@RestController
public class ValidateUserController {

	@Autowired
	ValidateUserServices validateUserServices;

	@GetMapping("/customerdetails/{customerID}")
	public LoginServicesDTO getCustomerDetails(@PathVariable String customerID) {
		LoginServicesDTO detailsOfCustomer = validateUserServices.validateUser(customerID);
		return detailsOfCustomer;
	}
}
