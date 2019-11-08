package com.nagarro.adminPanel.services;

public interface RechargeWalletServices {

	/**
	 * This method adds recharge amount to customer balance by calling CustomerDao's
	 * updateCustomerBalance.
	 * 
	 * @param customerID
	 * @param rechargeAmount
	 */
	public void rechargeWallet(String customerID, double rechargeAmount);

}
