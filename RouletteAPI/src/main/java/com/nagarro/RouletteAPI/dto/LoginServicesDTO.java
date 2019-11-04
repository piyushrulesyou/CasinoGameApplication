package com.nagarro.RouletteAPI.dto;

public class LoginServicesDTO {

	private String customerName;
	private double accountBalance;

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
		return "LoginServicesDTO [customerName=" + customerName + ", accountBalance=" + accountBalance + "]";
	}

}
