package com.nagarro.adminPanel.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.adminPanel.dto.BlockAmountDTO;
import com.nagarro.adminPanel.services.BlockAmountServices;

/**
 * This class is used for blocking the amount when the user is playing the
 * roulette game.
 * 
 * @author piyushagarwal01
 *
 */
@RestController
public class BlockAmountController {

	final static Logger LOG = Logger.getLogger(UserRegistrationController.class);

	@Autowired
	BlockAmountServices blockAmountServices;

	/**
	 * This method accepts GET request from Roulette API for
	 * /customer/{customerId}/block_amount/{blockAmount} and calls block amount
	 * service to block the received amount from customer's balance.
	 * 
	 * @param customerId  Unique ID of customer
	 * @param blockAmount Amount to be blocked
	 * @return BlockAmountResponse Object having success status and updated
	 *         customer's balance.
	 */
	@GetMapping("/blockPlayAmount/{customerID}/{amountBlock}")
	public BlockAmountDTO validateAndBlockAmount(@PathVariable String customerID, @PathVariable String amountBlock) {

		LOG.info("Recieved GET request for /block_amount for customerId : " + customerID);

		double blockAmount = Double.parseDouble(amountBlock);

		BlockAmountDTO isEligibleCustomer = blockAmountServices.validateUserAndBlockAmount(customerID, blockAmount);

		return isEligibleCustomer;
	}

}
