package com.nagarro.adminPanel.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.adminPanel.services.RechargeWalletServices;

/**
 * This class recharges the wallet of the customer using the customerID and the
 * recharge amount.
 * 
 * @author piyushagarwal01
 *
 */
@Controller
public class RechargeWalletController {

	final static Logger LOG = Logger.getLogger(RechargeWalletController.class);

	@Autowired
	RechargeWalletServices rechargeWalletServices;

	@Autowired
	UserListController userListController;

	/**
	 * This method accepts POST request for /recharge and adds recharge amount in
	 * customer's balance.
	 * 
	 * @param customerId     Unique ID of customer.
	 * @param rechargeAmount Amount to be added in customer's account.
	 * @return
	 * @throws Exception
	 */

	@RequestMapping(value = "rechargeWallet", method = RequestMethod.POST)
	public ModelAndView rechargeUserWallet(HttpServletRequest request, HttpServletResponse response) throws Exception {

		LOG.info("Recieved POST request for /rechargeWallet");

		String customerID = request.getParameter("rechargeID");
		double rechargeAmount = Double.parseDouble(request.getParameter("rechargeAmount"));

		rechargeWalletServices.rechargeWallet(customerID, rechargeAmount);

		ModelAndView modelAndView = null;

		modelAndView = userListController.showUserList(request, response);

		return modelAndView;
	}
}
