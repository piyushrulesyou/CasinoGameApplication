package com.nagarro.RouletteAPI.services;

import org.springframework.stereotype.Service;

import com.nagarro.RouletteAPI.dto.GameResultDTO;
import com.nagarro.RouletteAPI.utilities.CalculateFinalWonAmount;
import com.nagarro.RouletteAPI.utilities.PredictGameResult;
import com.nagarro.RouletteAPI.utilities.RandomNumberGenerator;

@Service
public class GamePlayingServicesImpl implements GamePlayingServices {

	public GameResultDTO calculateGameResult(double blockAmount, int numberChosen) {

		GameResultDTO gameResultDTO = new GameResultDTO();

		int rouletteSpinResult = RandomNumberGenerator.randomNumberGenerator();

		System.out.println("6 " + rouletteSpinResult);

		boolean gameResult = false;
		gameResult = PredictGameResult.isGameWon(numberChosen, rouletteSpinResult);

		System.out.println("7 " + gameResult);

		double finalBlockAmount = 0;
		if (gameResult) {
			finalBlockAmount = CalculateFinalWonAmount.calculateFinalWonAmount(blockAmount, numberChosen);
		}

		System.out.println("8 " + finalBlockAmount);

		gameResultDTO.setGameResult(gameResult);
		gameResultDTO.setFinalUserBlockAmount(finalBlockAmount);
		gameResultDTO.setResultantNumber(rouletteSpinResult);

		return gameResultDTO;

	}

}