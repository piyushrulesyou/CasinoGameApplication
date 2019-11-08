package com.nagarro.adminPanel.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.adminPanel.dao.FetchAndUpdateCustomerDao;
import com.nagarro.adminPanel.dto.UpdatedFinalAmountDTO;
import com.nagarro.adminPanel.model.CustomerDetails;

@Service
public class AdjustFinalAmountServicesImpl implements AdjustFinalAmountServices {

	final static Logger LOG = Logger.getLogger(AdjustFinalAmountServicesImpl.class);

	@Autowired
	FetchAndUpdateCustomerDao fetchAndUpdateCustomerDao;

	UpdatedFinalAmountDTO updatedUserBalanceDTO = new UpdatedFinalAmountDTO();

	public UpdatedFinalAmountDTO updateFinalAmountBalance(String customerID, double finalAmountWonLost) {

		LOG.info("Inside service for updating the final amount balance");

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
