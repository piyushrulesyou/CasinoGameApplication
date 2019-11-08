package com.nagarro.RouletteAPI.services;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagarro.RouletteAPI.constants.Constants;
import com.nagarro.RouletteAPI.dto.GameResultDTO;
import com.nagarro.RouletteAPI.dto.UpdatedFinalAmountDTO;

@Service
public class UpdateUserAccountInDBServicesImpl implements UpdateUserAccountInDBServices {

	final static Logger LOG = Logger.getLogger(UpdateUserAccountInDBServicesImpl.class);

	@Override
	public double updateUserInfoInDB(String customerID, GameResultDTO gameResultDTO) {

		LOG.info("Inside service for updating the user info in the DB");

		final String uri = Constants.uriUpdateUserAccount;

		double finalUserBlockAmount = gameResultDTO.getFinalUserBlockAmount();

		Map<String, String> updateUserAccount = new HashMap<>();
		updateUserAccount.put("customerID", customerID);
		updateUserAccount.put("finalAmountWonLost", "" + finalUserBlockAmount);

		RestTemplate restTemplate = new RestTemplate();

		UpdatedFinalAmountDTO updatedCustomerAccountBalance = restTemplate.getForObject(uri,
				UpdatedFinalAmountDTO.class, updateUserAccount);

		return updatedCustomerAccountBalance.getFinalAmountBalance();

	}

}
