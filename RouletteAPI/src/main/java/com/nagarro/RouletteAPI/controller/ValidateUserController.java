package com.nagarro.RouletteAPI.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nagarro.RouletteAPI.services.ValidateUserServices;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

@Path("validate")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ValidateUserController {

	@Autowired
	ValidateUserServices validateUserServices;

	WebResource webResource;
	ObjectMapper mapper = new ObjectMapper();

	@GET
	@Path("validateUser/{customerID}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response validateUserAndGetUserDetails(@PathParam("customerID") String customerID) {

		webResource = validateUserServices.validateUserAndGetUserDetails(customerID);

		String response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class)
				.getEntity(String.class);

		return Response.status(200).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
				.header("Access-Control-Max-Age", "1209600").entity(response).build();

	}

}
