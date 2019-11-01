package com.nagarro.adminPanel.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.adminPanel.dao.RechargeWalletDao;

@Service
public class RechargeWalletServicesImpl implements RechargeWalletServices {

	@Autowired
	RechargeWalletDao rechargeWalletDao;

	public void rechargeWallet(String customerID, double rechargeAmount) {
		rechargeWalletDao.rechargeInDB(customerID, rechargeAmount);
	}

}
