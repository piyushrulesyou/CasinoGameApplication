package com.nagarro.adminPanel.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.adminPanel.dao.FetchAndUpdateCustomerDao;
import com.nagarro.adminPanel.dto.UpdatedFinalAmountDTO;
import com.nagarro.adminPanel.model.CustomerDetails;

@Service
public class AdjustFinalAmountServicesImpl implements AdjustFinalAmountServices {

	@Autowired
	FetchAndUpdateCustomerDao fetchAndUpdateCustomerDao;

	UpdatedFinalAmountDTO updatedUserBalanceDTO = new UpdatedFinalAmountDTO();

	public UpdatedFinalAmountDTO updateFinalAmountBalance(String customerID, double finalAmountWonLost) {

//		int wonOrLost = (int) finalAmountWonLost % 10;
//		boolean gameWon = true;
//
//		double amountToBeAdjusted = finalAmountWonLost / 10;
//
//		if (wonOrLost == 0) {
//			gameWon = false;
//		}

		CustomerDetails userInformation = fetchAndUpdateCustomerDao.fetchCustomerDetails(customerID);

		double accountBalance = userInformation.getAccountBalance();
//		double blockedAmount = userInformation.getBlockedAmount();

		double finalAccountBalance;

//		if (gameWon)
		finalAccountBalance = accountBalance + finalAmountWonLost;
//		else
//			finalAccountBalance = accountBalance + blockedAmount - amountToBeAdjusted;

		double finalBlockedAmount = 0;

		userInformation.setAccountBalance(finalAccountBalance);
		userInformation.setBlockedAmount(finalBlockedAmount);

		fetchAndUpdateCustomerDao.updateCustomerDetails(userInformation);

		updatedUserBalanceDTO.setFinalAmountBalance(finalAccountBalance);

		return updatedUserBalanceDTO;
	}

}
