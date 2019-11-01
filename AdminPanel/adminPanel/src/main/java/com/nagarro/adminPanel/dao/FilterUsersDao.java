package com.nagarro.adminPanel.dao;

import java.util.List;

import com.nagarro.adminPanel.model.CustomerDetails;

public interface FilterUsersDao {

	public List<CustomerDetails> filterList(String filterName, String filterContact, String filterEMail);

}