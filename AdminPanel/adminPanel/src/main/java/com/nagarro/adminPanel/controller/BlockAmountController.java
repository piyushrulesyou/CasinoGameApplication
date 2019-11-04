package com.nagarro.adminPanel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.adminPanel.dto.BlockAmountDTO;
import com.nagarro.adminPanel.services.BlockAmountServices;

@RestController
public class BlockAmountController {

	@Autowired
	BlockAmountServices blockAmountServices;

	@GetMapping("/blockPlayAmount/{customerID}/{blockAmount}")
	public BlockAmountDTO validateAndBlockAmount(@PathVariable String customerID, @PathVariable double blockAmount) {

		BlockAmountDTO isEligibleCustomer = blockAmountServices.validateUserAndBlockAmount(customerID, blockAmount);
		return isEligibleCustomer;
	}

}
