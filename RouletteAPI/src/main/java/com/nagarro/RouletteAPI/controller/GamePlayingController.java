package com.nagarro.RouletteAPI.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.RouletteAPI.dto.BlockAmountDTO;
import com.nagarro.RouletteAPI.dto.GameResultDTO;
import com.nagarro.RouletteAPI.services.BlockAmountServices;
import com.nagarro.RouletteAPI.services.GamePlayingServices;
import com.nagarro.RouletteAPI.services.UpdateUserAccountInDBServices;
import com.nagarro.RouletteAPI.utilities.SegmentToNumberChosenRoulette;

@Path("play")
//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class GamePlayingController {

	@Autowired
	BlockAmountServices blockAmountServices;

	@Autowired
	GamePlayingServices gamePlayingServices;

	@Autowired
	UpdateUserAccountInDBServices updateUserAccountInDBServices;

	@GET
	@Path("playGame/{customerID}/{blockAmount}/{segmentChosen}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public GameResultDTO blockUserAmount(@PathParam("customerID") String customerID,
			@PathParam("blockAmount") double blockAmount, @PathParam("segmentChosen") int segmentChosen) {

		GameResultDTO gameResultDTO = null;

		BlockAmountDTO isEligibleCustomer = blockAmountServices.isValidGameAndBlockAmount(customerID, blockAmount);

		if (isEligibleCustomer.getIsValidGame()) {

//			int numberChosen = SegmentToNumberChosenRoulette.convertSegmentToNumber(segmentChosen);
			
			gameResultDTO = gamePlayingServices.calculateGameResult(blockAmount, segmentChosen);

			double finalUserAccountBalance = updateUserAccountInDBServices.updateUserInfoInDB(customerID,
					gameResultDTO);

			gameResultDTO.setFinalUserAccountBalance(finalUserAccountBalance);

			return gameResultDTO;

		} else {
			return gameResultDTO;
		}

	}

}
