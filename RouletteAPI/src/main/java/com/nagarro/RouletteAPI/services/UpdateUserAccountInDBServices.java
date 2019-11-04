package com.nagarro.RouletteAPI.services;

import com.nagarro.RouletteAPI.dto.GameResultDTO;
import com.nagarro.RouletteAPI.dto.UpdatedFinalAmountDTO;

public interface UpdateUserAccountInDBServices {

	public double updateUserInfoInDB(String customerID, GameResultDTO gameResultDTO);

}