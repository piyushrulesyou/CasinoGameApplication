package com.nagarro.adminPanel.dao;

import java.sql.Blob;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.nagarro.adminPanel.model.CustomerDetails;

public interface UserRegistrationDao {

	public String registerUserInDB(CustomerDetails userInformation);

}