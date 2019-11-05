package com.nagarro.RouletteAPI.dto;

public class RouletteValidate {

	private String customerID;

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	@Override
	public String toString() {
		return "RouletteValidate [customerID=" + customerID + "]";
	}

}
