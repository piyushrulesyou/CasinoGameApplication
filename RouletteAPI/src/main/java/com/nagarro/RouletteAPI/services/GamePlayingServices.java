package com.nagarro.RouletteAPI.services;

import com.nagarro.RouletteAPI.dto.GameResultDTO;

public interface GamePlayingServices {

	/**
	 * This method calculates the game result after the user has blocked amount on a
	 * particular segment.
	 * 
	 * @param blockAmount
	 * @param numberChosen
	 * @return It returns the final game result after the result is evaluated.
	 */
	public GameResultDTO calculateGameResult(double blockAmount, int numberChosen);

}
