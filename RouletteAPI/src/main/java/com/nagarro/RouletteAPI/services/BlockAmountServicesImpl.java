package com.nagarro.RouletteAPI.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagarro.RouletteAPI.constants.Constants;
import com.nagarro.RouletteAPI.dto.BlockAmountDTO;

@Service
public class BlockAmountServicesImpl implements BlockAmountServices {

	public BlockAmountDTO isValidGameAndBlockAmount(String customerID, double blockAmount) {

		final String uri = Constants.uriBlockAmount;

		Map<String, String> blockPlayAmount = new HashMap<>();
		blockPlayAmount.put("customerID", customerID);
		blockPlayAmount.put("blockAmount", "" + blockAmount);

		RestTemplate restTemplate = new RestTemplate();

		BlockAmountDTO userGameEligibility = new BlockAmountDTO();
		
		userGameEligibility = restTemplate.getForObject(uri, BlockAmountDTO.class, blockPlayAmount);
		return userGameEligibility;

	}

}
