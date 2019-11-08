package com.nagarro.adminPanel.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.adminPanel.dao.FilterUsersDao;
import com.nagarro.adminPanel.model.CustomerDetails;

@Service
public class FilterUsersServicesImpl implements FilterUsersServices {

	final static Logger LOG = Logger.getLogger(FilterUsersServicesImpl.class);

	@Autowired
	FilterUsersDao filterUsersDao;

	public List<CustomerDetails> filterUsersList(String filterName, String filterContact, String filterEMail) {

		LOG.info("Inside service for filtering the users based on the user input.");

		List<CustomerDetails> usersList = filterUsersDao.filterList(filterName, filterContact, filterEMail);

		return usersList;

	}

}
