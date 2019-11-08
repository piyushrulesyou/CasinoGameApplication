package com.nagarro.adminPanel.dto;

/**
 * /** This class is used for sending response of login Request. Success
 * property determines whether the login was successful or not.
 * 
 * @author piyushagarwal01
 *
 */
public class LoginServicesDTO {

	private String customerID;
	private String customerName;
	private double accountBalance;

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	@Override
	public String toString() {
		return "LoginServicesDTO [customerID=" + customerID + ", customerName=" + customerName + ", accountBalance="
				+ accountBalance + "]";
	}
}
