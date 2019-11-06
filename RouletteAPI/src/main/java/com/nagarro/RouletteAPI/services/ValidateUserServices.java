package com.nagarro.RouletteAPI.services;

import com.nagarro.RouletteAPI.dto.LoginServicesDTO;
import com.sun.jersey.api.client.WebResource;

public interface ValidateUserServices {

	public WebResource validateUserAndGetUserDetails(String customerID);

}
