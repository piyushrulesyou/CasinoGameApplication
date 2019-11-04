package com.nagarro.RouletteAPI.services;

import com.nagarro.RouletteAPI.dto.LoginServicesDTO;

public interface ValidateUserServices {

	public LoginServicesDTO validateUserAndGetUserDetails(String customerID);

}
