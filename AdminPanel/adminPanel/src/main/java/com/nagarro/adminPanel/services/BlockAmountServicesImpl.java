package com.nagarro.adminPanel.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.adminPanel.dao.FetchAndUpdateCustomerDao;
import com.nagarro.adminPanel.dto.BlockAmountDTO;
import com.nagarro.adminPanel.model.CustomerDetails;

@Service
public class BlockAmountServicesImpl implements BlockAmountServices {

	@Autowired
	FetchAndUpdateCustomerDao fetchAndUpdateCustomerDao;
	
	BlockAmountDTO isCustomerEligible = new BlockAmountDTO();

	@Override
	public BlockAmountDTO validateUserAndBlockAmount(String customerID, double blockAmount) {

		CustomerDetails userInformation = fetchAndUpdateCustomerDao.fetchCustomerDetails(customerID);

		double customerAccountBalance = userInformation.getAccountBalance();
		double customerBlockedBalance = userInformation.getBlockedAmount();

		if (blockAmount <= customerAccountBalance) {
			double updatedAccountBalance = customerAccountBalance - blockAmount;
			userInformation.setAccountBalance(updatedAccountBalance);

			double updatedBlockedBalance = customerBlockedBalance + blockAmount;
			userInformation.setBlockedAmount(updatedBlockedBalance);

			isCustomerEligible.setValidGame(true);
			isCustomerEligible.setAvailableAccountBalance(updatedAccountBalance);
			isCustomerEligible.setBlockedAmount(updatedBlockedBalance);

			fetchAndUpdateCustomerDao.updateCustomerDetails(userInformation);

		}

		else {

			isCustomerEligible.setValidGame(false);
			isCustomerEligible.setAvailableAccountBalance(userInformation.getAccountBalance());
			isCustomerEligible.setBlockedAmount(userInformation.getBlockedAmount());

		}

		return isCustomerEligible;

	}

}
