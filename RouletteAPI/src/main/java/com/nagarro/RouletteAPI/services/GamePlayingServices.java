package com.nagarro.RouletteAPI.services;

import com.nagarro.RouletteAPI.dto.GameResultDTO;

public interface GamePlayingServices {

	public GameResultDTO calculateGameResult(double blockAmount, int numberChosen);
	
}
