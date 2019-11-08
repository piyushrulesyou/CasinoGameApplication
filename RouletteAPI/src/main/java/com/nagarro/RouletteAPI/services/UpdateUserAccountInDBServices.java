package com.nagarro.RouletteAPI.services;

import com.nagarro.RouletteAPI.dto.GameResultDTO;

public interface UpdateUserAccountInDBServices {

	/**
	 * This method updates the value of the user after the game has been played.
	 * 
	 * @param customerID
	 * @param gameResultDTO
	 * @return
	 */
	public double updateUserInfoInDB(String customerID, GameResultDTO gameResultDTO);

}