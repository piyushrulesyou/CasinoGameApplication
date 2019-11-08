package com.nagarro.adminPanel.services;

import java.sql.Blob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.nagarro.adminPanel.dao.UserRegistrationDao;
import com.nagarro.adminPanel.model.CustomerDetails;

@Service
public class UserRegistrationServicesImpl implements UserRegistrationServices {

	@Autowired
	UserRegistrationDao userRegistrationDao;

	public String registerUser(CustomerDetails userInformation) {

//		System.out.println(idProof.getName());
		
//		userInformation.setIdProof(idProof);
		
		String newCustomerID = userRegistrationDao.registerUserInDB(userInformation);

		return newCustomerID;
	}

}
