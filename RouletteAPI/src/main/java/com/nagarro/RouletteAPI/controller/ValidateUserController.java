package com.nagarro.RouletteAPI.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.nagarro.RouletteAPI.dto.LoginServicesDTO;
import com.nagarro.RouletteAPI.services.ValidateUserServices;

@Path("validate")
@Controller
public class ValidateUserController {

	@Autowired
	ValidateUserServices validateUserServices;

	// Global Cross origins
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/*").allowedOrigins("*");
			}
		};
	}

	@GET
	@Path("validateUser/{customerID}")
	@Produces({ MediaType.APPLICATION_JSON}) //, MediaType.APPLICATION_XML })
	public LoginServicesDTO validateUserAndGetUserDetails(@PathParam("customerID") String customerID) {

		LoginServicesDTO userInformation = validateUserServices.validateUserAndGetUserDetails(customerID);

		System.out.println("3 " + userInformation.getAccountBalance());

		return userInformation;
	}

}
