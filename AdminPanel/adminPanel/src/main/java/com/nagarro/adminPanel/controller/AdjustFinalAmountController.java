package com.nagarro.adminPanel.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.adminPanel.dto.UpdatedFinalAmountDTO;
import com.nagarro.adminPanel.services.AdjustFinalAmountServices;

/**
 * This method is used for adjusting the final account balance of the user.
 * 
 * @author piyushagarwal01
 *
 */
@RestController
public class AdjustFinalAmountController {

	final static Logger LOG = Logger.getLogger(UserRegistrationController.class);

	@Autowired
	AdjustFinalAmountServices adjustFinalAmountServices;

	/**
	 * This method accepts GET request from Roulette API for
	 * /customer/{customerId}/adjust_amount/{adjustAmount} and calls adjust amount
	 * service to adjust the received amount in customer's balance.
	 * 
	 * @param customerId   Unique ID of customer
	 * @param adjustAmount Amount to be adjusted
	 * @return AdjustAmountResponse Object having success status and updated
	 *         customer's balance.
	 */
	@GetMapping("/adjustFinal/{customerID}/{finalAmountWonLost:.+}")
	public UpdatedFinalAmountDTO updateFinalAmountBalance(@PathVariable String customerID,
			@PathVariable String finalAmountWonLost) {

		LOG.info("Recieved GET request for /adjust_amount for customerId : " + customerID);

		double finalAmountToBeAdjust = Double.parseDouble(finalAmountWonLost);

		UpdatedFinalAmountDTO updatedUserInformation = adjustFinalAmountServices.updateFinalAmountBalance(customerID,
				finalAmountToBeAdjust);

		return updatedUserInformation;

	}

}
