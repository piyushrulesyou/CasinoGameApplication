package com.nagarro.RouletteAPI.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagarro.RouletteAPI.constants.Constants;
import com.nagarro.RouletteAPI.dto.GameResultDTO;
import com.nagarro.RouletteAPI.dto.UpdatedFinalAmountDTO;

@Service
public class UpdateUserAccountInDBServicesImpl implements UpdateUserAccountInDBServices {

	@Override
	public double updateUserInfoInDB(String customerID, GameResultDTO gameResultDTO) {

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
