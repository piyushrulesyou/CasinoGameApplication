package com.nagarro.RouletteAPI.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.RouletteAPI.dto.LoginServicesDTO;
import com.nagarro.RouletteAPI.services.ValidateUserServices;

@Path("validate")
//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ValidateUserController {

	@Autowired
	ValidateUserServices validateUserServices;

//	// Global Cross origins
//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurerAdapter() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/*").allowedOrigins("*");
//			}
//		};
//	}

	@GET
	@Path("validateUser/{customerID}")
//	@CrossOrigin(origins = "*")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public LoginServicesDTO validateUserAndGetUserDetails(@PathParam("customerID") String customerID) {

		LoginServicesDTO userInformation = validateUserServices.validateUserAndGetUserDetails(customerID);
		return userInformation;
	}

}
