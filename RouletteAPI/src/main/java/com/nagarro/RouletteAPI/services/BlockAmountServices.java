package com.nagarro.RouletteAPI.services;

import com.nagarro.RouletteAPI.dto.BlockAmountDTO;

public interface BlockAmountServices {

	/**
	 * /** This method accepts customer ID and amount to be blocked. It requests
	 * Administrator Application for blocking blockAmount from customer's balance.
	 * 
	 * @param customerId  Unique ID of customer
	 * @param blockAmount Amount to be blocked
	 * @return BlockAmountResponse that has success status and customer's updated
	 *         balance
	 *
	 */
	public BlockAmountDTO isValidGameAndBlockAmount(String customerID, double blockAmount);
}