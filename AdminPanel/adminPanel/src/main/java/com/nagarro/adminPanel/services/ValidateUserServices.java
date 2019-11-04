package com.nagarro.adminPanel.services;

import com.nagarro.adminPanel.dto.LoginServicesDTO;

public interface ValidateUserServices {

	public LoginServicesDTO validateUser(String customerID);

}