package com.nagarro.RouletteAPI.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagarro.RouletteAPI.constants.Constants;
import com.nagarro.RouletteAPI.dto.LoginServicesDTO;

@Service
public class ValidateUserServicesImpl implements ValidateUserServices {

	public LoginServicesDTO validateUserAndGetUserDetails(String customerID) {

		final String uri = Constants.uriValidateUser;

		Map<String, String> mapValidate = new HashMap<>();
		mapValidate.put("customerID", customerID);

		RestTemplate restTemplate = new RestTemplate();

		LoginServicesDTO userInformation = restTemplate.getForObject(uri, LoginServicesDTO.class, mapValidate);

		return userInformation;
	}

}
