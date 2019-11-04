package com.nagarro.adminPanel.services;

import com.nagarro.adminPanel.dto.UpdatedFinalAmountDTO;

public interface AdjustFinalAmountServices {
	public UpdatedFinalAmountDTO updateFinalAmountBalance(String customerID, double finalAmountWonLost);
}