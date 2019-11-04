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

@Path("play")
@Controller
public class GamePlayingController {

	@Autowired
	BlockAmountServices blockAmountServices;

	@Autowired
	GamePlayingServices gamePlayingServices;

	@Autowired
	UpdateUserAccountInDBServices updateUserAccountInDBServices;

	@GET
	@Path("playGame/{customerID}/{blockAmount}/{numberChosen}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public GameResultDTO blockUserAmount(@PathParam("customerID") String customerID,
			@PathParam("blockAmount") double blockAmount, @PathParam("numberChosen") int numberChosen) {

		GameResultDTO gameResultDTO = null;

		BlockAmountDTO isEligibleCustomer = blockAmountServices.isValidGameAndBlockAmount(customerID, blockAmount);

		if (isEligibleCustomer.getIsValidGame()) {

			gameResultDTO = gamePlayingServices.calculateGameResult(blockAmount, numberChosen);

			double finalUserAccountBalance = updateUserAccountInDBServices.updateUserInfoInDB(customerID,
					gameResultDTO);

			gameResultDTO.setFinalUserAccountBalance(finalUserAccountBalance);

			return gameResultDTO;

		} else {
			return gameResultDTO;
		}

	}

}
