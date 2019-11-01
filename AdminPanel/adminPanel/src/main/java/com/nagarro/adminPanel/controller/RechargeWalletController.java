package com.nagarro.adminPanel.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.adminPanel.services.RechargeWalletServices;

@Controller
public class RechargeWalletController {

	@Autowired
	RechargeWalletServices rechargeWalletServices;

	@Autowired
	UserListController userListController;

	@RequestMapping(value = "rechargeWallet", method = RequestMethod.POST)
	public ModelAndView rechargeUserWallet(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String customerID = request.getParameter("rechargeID");
		double rechargeAmount = Double.parseDouble(request.getParameter("rechargeAmount"));

		rechargeWalletServices.rechargeWallet(customerID, rechargeAmount);

		ModelAndView modelAndView = null;

		modelAndView = userListController.showUserList(request, response);

		return modelAndView;
	}
}
