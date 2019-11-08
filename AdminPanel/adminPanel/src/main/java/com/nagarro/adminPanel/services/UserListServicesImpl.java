package com.nagarro.adminPanel.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.adminPanel.dao.UserListDao;
import com.nagarro.adminPanel.model.CustomerDetails;

@Service
public class UserListServicesImpl implements UserListServices {

	final static Logger LOG = Logger.getLogger(UserListServicesImpl.class);

	@Autowired
	UserListDao userListDao;

	public List<CustomerDetails> fetchAllUsers() {

		LOG.info("Inside service for fetching the details of the users");

		List<CustomerDetails> listOfAllUsers = userListDao.fetchAllUsers();

		return listOfAllUsers;

	}

}
