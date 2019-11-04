package com.nagarro.adminPanel.dto;

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
