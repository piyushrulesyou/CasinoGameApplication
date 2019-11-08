package com.nagarro.adminPanel.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.adminPanel.model.CustomerDetails;
import com.nagarro.adminPanel.services.UserListServices;

/**
 * This class returns the list of all the customers which are registered with
 * the Casino Database.
 * 
 * @author piyushagarwal01
 *
 */
@Controller
public class UserListController {

	final static Logger LOG = Logger.getLogger(UserListController.class);

	@Autowired
	UserListServices userListServices;

	/**
	 * This method accepts GET request for /customers and return customers page that
	 * has the list of registered customers with their details and Administrator can
	 * filter customer and recharge their account balance. This method uses filter
	 * data inside the request URL.
	 * 
	 * @param request
	 * @param response
	 * @return ModelAndView Object with register view and current page name (for
	 *         activating it in the navigation bar).
	 */
	@RequestMapping(value = "showUsers", method = RequestMethod.GET)
	public ModelAndView showUserList(HttpServletRequest request, HttpServletResponse response) {

		LOG.info("Recieved GET request for showUsers");

		List<CustomerDetails> listOfUsers = new ArrayList<CustomerDetails>();

		ModelAndView modelAndView = null;

		listOfUsers = userListServices.fetchAllUsers();

		int userCounter = 0;

		modelAndView = new ModelAndView("UsersList");
		modelAndView.addObject("listOfUsers", listOfUsers);
		modelAndView.addObject("userCounter", userCounter);

		LOG.info("Returned list of all customers.");

		return modelAndView;
	}
}
