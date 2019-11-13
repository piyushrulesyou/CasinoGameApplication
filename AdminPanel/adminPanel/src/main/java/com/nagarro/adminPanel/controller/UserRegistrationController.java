package com.nagarro.adminPanel.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.adminPanel.model.CustomerDetails;
import com.nagarro.adminPanel.services.UserRegistrationServices;
import com.nagarro.adminPanel.utilities.AgeCalculator;
import com.nagarro.adminPanel.utilities.GenerateRandomID;

/**
 * This class is used for registering the user in the database. It takes input
 * from the user via admin and save the data in the database.
 * 
 * @author piyushagarwal01
 *
 */
@Controller
public class UserRegistrationController {

	final static Logger LOG = Logger.getLogger(UserRegistrationController.class);

	@Autowired
	UserRegistrationServices userRegistrationServices;

	/**
	 * This function triggers the JSP Page for the admin to enter the details of the
	 * customer.
	 * 
	 * @param request
	 * @param response
	 * @param errorMessage This message is used when error occurs during registering
	 *                     the customer in the database.
	 * @return It returns the instance of the customer object to the JSP Page.
	 * @throws Exception
	 */
	@RequestMapping(value = "register", method = RequestMethod.GET)
	public ModelAndView showRegisterPage(HttpServletRequest request, HttpServletResponse response, String errorMessage)
			throws Exception {

		LOG.info("Inside controller for sending customer instance to register user page.");

		ModelAndView modelAndView = new ModelAndView("RegisterUser");
		modelAndView.addObject("customerDetails", new CustomerDetails());
		modelAndView.addObject("statusMessage", errorMessage);
		return modelAndView;
	}

	/**
	 * This function takes the input from the admin and store it in the database.
	 * 
	 * @param request
	 * @param response
	 * @param userInformation This object contains the details of the user.
	 * @return Post successful registration of the user in the database it will
	 *         return to the index page.
	 * @throws Exception
	 */
	@RequestMapping(value = "registerUser", method = RequestMethod.POST)
	public ModelAndView registerNewUser(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("customerDetails") CustomerDetails userInformation,
			@RequestParam("idProofImage") CommonsMultipartFile idProofImage) throws Exception {

		LOG.info("Inside controller for registering user.");

		String dateOfBirth = userInformation.getDateOfBirth();
		String emailID = userInformation.getEmailID();
		String contactNumber = userInformation.getContactNumber();
		String customerName = userInformation.getCustomerName();

		/**
		 * This function checks whether the user is above 18 years or not.
		 */
		boolean is18Above = AgeCalculator.isValidAge(dateOfBirth);

		ModelAndView modelAndView = null;

		if (!is18Above) {

			LOG.info("The user is not above 18 years hence the registration was not successful.");

			String errorMessage = "Invalid User!! Age should be greater than 18 Years";
			modelAndView = showRegisterPage(request, response, errorMessage);
			return modelAndView;

		}

		LOG.info("The user is above 18 years hence the registration process will be proceeded.");

		/**
		 * This method will be called to generate a unique random customer ID.
		 */
		String customerID = GenerateRandomID.generateID(emailID, contactNumber, customerName);

		userInformation.setCustomerID(customerID);
		userInformation.setAccountBalance(500);

		String newCustomerID = null;

		/**
		 * This variable is used to check whether the customer registration was
		 * successful or not.
		 */
		newCustomerID = userRegistrationServices.registerUser(userInformation, idProofImage);

		if (newCustomerID == null) {

			LOG.info(
					"The customer registration has failed hence the admin will be redirected to enter the values again.");

			String errorMessage = "Please provide a valid input and try again!";
			modelAndView = new ModelAndView("RegisterUser");
			modelAndView.addObject("statusMessage", errorMessage);
			return modelAndView;
		}

		LOG.info("The customer registration is successful hence the admin will be redirected to the index page.");

		modelAndView = new ModelAndView("index");
		modelAndView.addObject("successMessage", newCustomerID);
		return modelAndView;
	}
}
