package com.nagarro.RouletteAPI.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.nagarro.RouletteAPI.constants.Constants;
import com.nagarro.RouletteAPI.dto.LoginServicesDTO;
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
