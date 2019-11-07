package com.nagarro.RouletteAPI.services;

import org.springframework.stereotype.Service;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

@Service
public class ValidateUserServicesImpl implements ValidateUserServices {

	public WebResource validateUserAndGetUserDetails(String customerID) {

		String uri = "http://localhost:8085/adminPanel/customerdetails/";
		
		Client client = Client.create();
		
		return client.resource(uri + customerID);
	}

}
