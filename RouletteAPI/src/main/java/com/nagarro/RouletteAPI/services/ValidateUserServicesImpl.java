package com.nagarro.RouletteAPI.services;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

@Service
public class ValidateUserServicesImpl implements ValidateUserServices {

	final static Logger LOG = Logger.getLogger(ValidateUserServicesImpl.class);

	public WebResource validateUserAndGetUserDetails(String customerID) {

		LOG.info("Inside service for validating the user and fetching the user details.");

		String uri = "http://localhost:8085/adminPanel/customerdetails/";

		Client client = Client.create();

		return client.resource(uri + customerID);
	}

}
