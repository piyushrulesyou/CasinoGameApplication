package com.nagarro.RouletteAPI.services;

import com.nagarro.RouletteAPI.dto.GameResultDTO;

public interface UpdateUserAccountInDBServices {

	public double updateUserInfoInDB(String customerID, GameResultDTO gameResultDTO);

}