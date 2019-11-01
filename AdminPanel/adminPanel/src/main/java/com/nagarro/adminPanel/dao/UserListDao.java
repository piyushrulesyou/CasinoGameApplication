package com.nagarro.adminPanel.dao;

import java.util.List;

import com.nagarro.adminPanel.model.CustomerDetails;

public interface UserListDao {

	List<CustomerDetails> fetchAllUsers();

}