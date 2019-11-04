package com.nagarro.adminPanel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.adminPanel.dao.ValidateUserDao;
import com.nagarro.adminPanel.model.CustomerDetails;

@RestController
public class ValidateUserController {

	@Autowired
	ValidateUserDao validateUserDao;

	@GetMapping("/customerdetails/{customerID}")
	public CustomerDetails getCustomerDetails(@PathVariable String customerID) {
		CustomerDetails detailsOfCustomer = validateUserDao.validateUser(customerID);
		return detailsOfCustomer;
	}
}
