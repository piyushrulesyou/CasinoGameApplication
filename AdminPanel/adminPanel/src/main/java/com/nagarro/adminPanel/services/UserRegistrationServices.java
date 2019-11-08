package com.nagarro.adminPanel.services;

import java.sql.Blob;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.nagarro.adminPanel.model.CustomerDetails;

public interface UserRegistrationServices {

	public String registerUser(CustomerDetails userInformation);

}