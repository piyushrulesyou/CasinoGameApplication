package com.nagarro.adminPanel.services;

import java.util.List;

import com.nagarro.adminPanel.model.CustomerDetails;

public interface FilterUsersServices {

	public List<CustomerDetails> filterUsersList(String filterName, String filterContact, String filterEMail);

}