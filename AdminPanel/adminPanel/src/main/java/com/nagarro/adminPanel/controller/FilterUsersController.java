package com.nagarro.adminPanel.controller;

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
import com.nagarro.adminPanel.services.FilterUsersServices;

/**
 * This method accepts POST request for /customers and return customers page
 * that has the list of registered customers with their details and
 * Administrator can filter customer and recharge their account balance. This
 * method uses filter data inside request body.
 * 
 * @author piyushagarwal01
 *
 */
@Controller
public class FilterUsersController {

	final static Logger LOG = Logger.getLogger(FilterUsersController.class);

	@Autowired
	FilterUsersServices filterUsersServices;

	@RequestMapping(value = "filterUsers", method = RequestMethod.POST)
	public ModelAndView filterUsersList(HttpServletRequest request, HttpServletResponse response) throws Exception {

		LOG.info("Recieved POST request for filterUsers");

		String filterName = request.getParameter("filterName");
		String filterContact = request.getParameter("filterContact");
		String filterEMail = request.getParameter("filterEMail");

		List<CustomerDetails> filteredUsers = filterUsersServices.filterUsersList(filterName, filterContact,
				filterEMail);

		ModelAndView modelAndView = new ModelAndView("UsersList");
		modelAndView.addObject("listOfUsers", filteredUsers);

		LOG.info("Fullfilled POST request for filterUsers");
		return modelAndView;

	}
}
