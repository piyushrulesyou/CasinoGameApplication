package com.nagarro.RouletteAPI.dto;

/**
 * This class is used for validating the identity of the customer before the
 * customer can play the roulette game.
 * 
 * @author piyushagarwal01
 *
 */
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
