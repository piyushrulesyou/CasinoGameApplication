package com.nagarro.adminPanel.dto;

/**
 * This class is used for sending response of Adjust Amount Request. Success
 * property determines whether the request was successful or not. Balance
 * property determines the updated balance of user after the request is
 * processed.
 * 
 * @author piyushagarwal01
 *
 */
public class UpdatedFinalAmountDTO {

	private double finalAmountBalance;

	public double getFinalAmountBalance() {
		return finalAmountBalance;
	}

	public void setFinalAmountBalance(double finalAmountBalance) {
		this.finalAmountBalance = finalAmountBalance;
	}

	@Override
	public String toString() {
		return "ReleaseFinalAmountDTO [finalAmountBalance=" + finalAmountBalance + "]";
	}

}
