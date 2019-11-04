package com.nagarro.RouletteAPI.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nagarro.RouletteAPI.dto.BlockAmountDTO;
import com.nagarro.RouletteAPI.services.BlockAmountServices;

@Path("block")
@Controller
public class BlockAmountController {

	@Autowired
	BlockAmountServices blockAmountServices;

	@GET
	@Path("blockAmount/{customerID}/{blockAmount}/{numberChosen}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public BlockAmountDTO blockUserAmount(@PathParam("customerID") String customerID,
			@PathParam("blockAmount") double blockAmount, @PathParam("numberChosen") int numberChosen) {

		BlockAmountDTO isEligibleCustomer = blockAmountServices.isValidGameAndBlockAmount(customerID, blockAmount);

		return isEligibleCustomer;

	}

}
