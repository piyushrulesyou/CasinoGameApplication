package com.nagarro.adminPanel.services;

import java.util.List;

import com.nagarro.adminPanel.model.CustomerDetails;

public interface UserListServices {

	List<CustomerDetails> fetchAllUsers();

}