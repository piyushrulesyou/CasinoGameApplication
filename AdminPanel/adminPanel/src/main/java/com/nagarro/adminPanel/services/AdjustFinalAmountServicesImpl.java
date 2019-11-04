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

		CustomerDetails userInformation = fetchAndUpdateCustomerDao.fetchCustomerDetails(customerID);

		double accountBalance = userInformation.getAccountBalance();

		double finalAccountBalance;

		finalAccountBalance = accountBalance + finalAmountWonLost;

		double finalBlockedAmount = 0;

		userInformation.setAccountBalance(finalAccountBalance);
		userInformation.setBlockedAmount(finalBlockedAmount);

		fetchAndUpdateCustomerDao.updateCustomerDetails(userInformation);

		updatedUserBalanceDTO.setFinalAmountBalance(finalAccountBalance);

		return updatedUserBalanceDTO;
	}

}
