package com.nagarro.adminPanel.services;

import com.nagarro.adminPanel.dto.BlockAmountDTO;

public interface BlockAmountServices {

	public BlockAmountDTO validateUserAndBlockAmount(String customerID, double blockAmount);

}