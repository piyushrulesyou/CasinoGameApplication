package com.nagarro.adminPanel.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.adminPanel.dao.RechargeWalletDao;

@Service
public class RechargeWalletServicesImpl implements RechargeWalletServices {

	final static Logger LOG = Logger.getLogger(RechargeWalletServicesImpl.class);

	@Autowired
	RechargeWalletDao rechargeWalletDao;

	public void rechargeWallet(String customerID, double rechargeAmount) {

		LOG.info("Inside service for recharing the customer wallet");

		rechargeWalletDao.rechargeInDB(customerID, rechargeAmount);
	}

}
