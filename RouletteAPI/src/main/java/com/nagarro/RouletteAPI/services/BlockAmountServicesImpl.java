package com.nagarro.RouletteAPI.services;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagarro.RouletteAPI.constants.Constants;
import com.nagarro.RouletteAPI.dto.BlockAmountDTO;

@Service
public class BlockAmountServicesImpl implements BlockAmountServices {

	final static Logger LOG = Logger.getLogger(BlockAmountServicesImpl.class);

	public BlockAmountDTO isValidGameAndBlockAmount(String customerID, double blockAmount) {

		LOG.info("Inside service for blocking the user amount");

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
