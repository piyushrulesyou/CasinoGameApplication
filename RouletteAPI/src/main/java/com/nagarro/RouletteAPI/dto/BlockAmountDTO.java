package com.nagarro.RouletteAPI.dto;

public class BlockAmountDTO {

	private boolean isValidGame;
	private double blockedAmount;
	private double availableAccountBalance;
	
	public boolean getIsValidGame() {
		return isValidGame;
	}
	public void setIsValidGame(boolean isValidGame) {
		this.isValidGame = isValidGame;
	}
	public double getBlockedAmount() {
		return blockedAmount;
	}
	public void setBlockedAmount(double blockedAmount) {
		this.blockedAmount = blockedAmount;
	}
	public double getAvailableAccountBalance() {
		return availableAccountBalance;
	}
	public void setAvailableAccountBalance(double availableAccountBalance) {
		this.availableAccountBalance = availableAccountBalance;
	}
	
	
	@Override
	public String toString() {
		return "BlockAmoundDTO [blockedAmount=" + blockedAmount + ", availableAccountBalance=" + availableAccountBalance
				+ "]";
	}
	
	
	
}
