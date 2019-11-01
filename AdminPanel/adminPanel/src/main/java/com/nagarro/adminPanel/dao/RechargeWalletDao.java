package com.nagarro.adminPanel.dao;

public interface RechargeWalletDao {

	public void rechargeInDB(String customerID, double rechargeAmount);

}