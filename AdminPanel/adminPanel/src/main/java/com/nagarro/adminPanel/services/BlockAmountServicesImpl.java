package com.nagarro.adminPanel.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.adminPanel.dao.FetchAndUpdateCustomerDao;
import com.nagarro.adminPanel.dto.BlockAmountDTO;
import com.nagarro.adminPanel.model.CustomerDetails;

@Service
public class BlockAmountServicesImpl implements BlockAmountServices {

	final static Logger LOG = Logger.getLogger(BlockAmountServicesImpl.class);

	@Autowired
	FetchAndUpdateCustomerDao fetchAndUpdateCustomerDao;

	BlockAmountDTO isCustomerEligible = new BlockAmountDTO();

	public BlockAmountDTO validateUserAndBlockAmount(String customerID, double blockAmount) {

		LOG.info("Inside service for validating the user and blocking the amount from DB");

		CustomerDetails userInformation = fetchAndUpdateCustomerDao.fetchCustomerDetails(customerID);

		double customerAccountBalance = userInformation.getAccountBalance();
		double customerBlockedBalance = userInformation.getBlockedAmount();

		if (blockAmount <= customerAccountBalance) {
			double updatedAccountBalance = customerAccountBalance - blockAmount;
			userInformation.setAccountBalance(updatedAccountBalance);

			double updatedBlockedBalance = customerBlockedBalance + blockAmount;
			userInformation.setBlockedAmount(updatedBlockedBalance);

			isCustomerEligible.setIsValidGame(true);
			isCustomerEligible.setAvailableAccountBalance(updatedAccountBalance);
			isCustomerEligible.setBlockedAmount(updatedBlockedBalance);

			fetchAndUpdateCustomerDao.updateCustomerDetails(userInformation);

		}

		else {

			isCustomerEligible.setIsValidGame(false);
			isCustomerEligible.setAvailableAccountBalance(userInformation.getAccountBalance());
			isCustomerEligible.setBlockedAmount(userInformation.getBlockedAmount());

		}

		return isCustomerEligible;

	}

}
