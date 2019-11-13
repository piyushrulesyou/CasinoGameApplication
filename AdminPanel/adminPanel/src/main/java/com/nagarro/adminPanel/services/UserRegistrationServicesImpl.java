package com.nagarro.adminPanel.services;

import java.sql.Blob;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.nagarro.adminPanel.dao.UserRegistrationDao;
import com.nagarro.adminPanel.model.CustomerDetails;

@Service
public class UserRegistrationServicesImpl implements UserRegistrationServices {

	final static Logger LOG = Logger.getLogger(UserRegistrationServicesImpl.class);

	@Autowired
	UserRegistrationDao userRegistrationDao;

	public String registerUser(CustomerDetails userInformation, CommonsMultipartFile idProofImage) {

		LOG.info("Inside service for registering the new user in DB");

		Blob idProofImageBlob = convertImageToBlob(idProofImage);

		userInformation.setIdProof(idProofImageBlob);

		String newCustomerID = userRegistrationDao.registerUserInDB(userInformation);

		return newCustomerID;
	}

	private Blob convertImageToBlob(CommonsMultipartFile idProofImageMultipart) {

		byte[] idProofContent = idProofImageMultipart.getBytes();
		Blob idProofBlob = null;
		try {
			idProofBlob = new SerialBlob(idProofContent);
		} catch (SerialException e) {
			LOG.error("SerialException : ", e);
		} catch (SQLException e) {
			LOG.error("SQLException : ", e);
		}

		return idProofBlob;
	}

}
