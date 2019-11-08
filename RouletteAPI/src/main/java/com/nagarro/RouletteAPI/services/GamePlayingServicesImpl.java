package com.nagarro.RouletteAPI.services;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.nagarro.RouletteAPI.dto.GameResultDTO;
import com.nagarro.RouletteAPI.utilities.CalculateFinalWonAmount;
import com.nagarro.RouletteAPI.utilities.PredictGameResult;
import com.nagarro.RouletteAPI.utilities.RandomNumberGenerator;

@Service
public class GamePlayingServicesImpl implements GamePlayingServices {

	final static Logger LOG = Logger.getLogger(GamePlayingServicesImpl.class);

	public GameResultDTO calculateGameResult(double blockAmount, int numberChosen) {

		LOG.info(
				"Inside service for calculating the game result based on the generated number and user chosen segment");

		GameResultDTO gameResultDTO = new GameResultDTO();

		int rouletteSpinResult = RandomNumberGenerator.randomNumberGenerator();

		boolean gameResult = false;
		gameResult = PredictGameResult.isGameWon(numberChosen, rouletteSpinResult);

		double finalBlockAmount = 0;
		if (gameResult) {
			finalBlockAmount = CalculateFinalWonAmount.calculateFinalWonAmount(blockAmount, numberChosen);
		}

		gameResultDTO.setGameResult(gameResult);
		gameResultDTO.setFinalUserBlockAmount(finalBlockAmount);
		gameResultDTO.setResultantNumber(rouletteSpinResult);

		return gameResultDTO;

	}

}