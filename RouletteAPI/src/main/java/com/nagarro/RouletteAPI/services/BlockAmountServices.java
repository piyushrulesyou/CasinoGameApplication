package com.nagarro.RouletteAPI.services;

import com.nagarro.RouletteAPI.dto.BlockAmountDTO;

public interface BlockAmountServices {
	public BlockAmountDTO isValidGameAndBlockAmount(String customerID, double blockAmount);
}