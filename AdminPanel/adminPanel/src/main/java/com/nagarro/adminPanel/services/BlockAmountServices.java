package com.nagarro.adminPanel.services;

import com.nagarro.adminPanel.dto.BlockAmountDTO;

public interface BlockAmountServices {

	/**
	 * This method calls CustomerDao's blockAmount method with customerId and amount
	 * to be blocked received as parameter.
	 * 
	 * @param customerID
	 * @param blockAmount
	 * @return The blocked amount of the customer
	 */
	public BlockAmountDTO validateUserAndBlockAmount(String customerID, double blockAmount);

}