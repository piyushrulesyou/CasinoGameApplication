package com.nagarro.RouletteAPI.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nagarro.RouletteAPI.dto.BlockAmountDTO;
import com.nagarro.RouletteAPI.dto.GameResultDTO;
import com.nagarro.RouletteAPI.services.BlockAmountServices;
import com.nagarro.RouletteAPI.services.GamePlayingServices;
import com.nagarro.RouletteAPI.services.UpdateUserAccountInDBServices;

@Path("block")
@Controller
public class BlockAmountController {

	@Autowired
	BlockAmountServices blockAmountServices;

	@Autowired
	GamePlayingServices gamePlayingServices;

	@Autowired
	UpdateUserAccountInDBServices updateUserAccountInDBServices;

	@GET
	@Path("blockAmount/{customerID}/{blockAmount}/{numberChosen}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public GameResultDTO blockUserAmount(@PathParam("customerID") String customerID,
			@PathParam("blockAmount") double blockAmount, @PathParam("numberChosen") int numberChosen) {

		GameResultDTO gameResultDTO = null;

		BlockAmountDTO isEligibleCustomer = blockAmountServices.isValidGameAndBlockAmount(customerID, blockAmount);

		System.out.println("1 " + isEligibleCustomer.getIsValidGame());
		System.out.println("2 " + isEligibleCustomer.getAvailableAccountBalance());
		System.out.println("3 " + isEligibleCustomer.getBlockedAmount());

		if (isEligibleCustomer.getIsValidGame()) {

			System.out.println("5 Inside is Eligible");

			gameResultDTO = gamePlayingServices.calculateGameResult(blockAmount, numberChosen);

			System.out.println("11 " + gameResultDTO.getFinalUserAccountBalance());

			double finalUserAccountBalance = updateUserAccountInDBServices.updateUserInfoInDB(customerID,
					gameResultDTO);

			gameResultDTO.setFinalUserAccountBalance(finalUserAccountBalance);

			System.out.println("20 " + finalUserAccountBalance);

			System.out.println("10 DONE");

			return gameResultDTO;

		} else {
			System.out.println("4 " + gameResultDTO);
			return gameResultDTO;
		}

	}

}
