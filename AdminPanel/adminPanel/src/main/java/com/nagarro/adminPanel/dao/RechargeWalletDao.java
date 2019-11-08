package com.nagarro.adminPanel.dao;

public interface RechargeWalletDao {

	/**
	 * /** This method updates the balance of customer that matches with customerId
	 * received as parameter.
	 * 
	 * @param id     Unique ID of customer
	 * @param amount Amount to be updated.
	 */
	public void rechargeInDB(String customerID, double rechargeAmount);

}