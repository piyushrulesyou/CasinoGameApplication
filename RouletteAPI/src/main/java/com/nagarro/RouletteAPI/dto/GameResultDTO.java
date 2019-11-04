package com.nagarro.RouletteAPI.dto;

public class GameResultDTO {

	private boolean gameResult;
	private int resultantNumber;
	private double finalUserBlockAmount;
	private double finalUserAccountBalance;

	public double getFinalUserAccountBalance() {
		return finalUserAccountBalance;
	}

	public void setFinalUserAccountBalance(double finalUserAccountBalance) {
		this.finalUserAccountBalance = finalUserAccountBalance;
	}

	public boolean getGameResult() {
		return gameResult;
	}

	public void setGameResult(boolean gameResult) {
		this.gameResult = gameResult;
	}

	public int getResultantNumber() {
		return resultantNumber;
	}

	public void setResultantNumber(int resultantNumber) {
		this.resultantNumber = resultantNumber;
	}

	public double getFinalUserBlockAmount() {
		return finalUserBlockAmount;
	}

	public void setFinalUserBlockAmount(double finalUserBlockAmount) {
		this.finalUserBlockAmount = finalUserBlockAmount;
	}

	@Override
	public String toString() {
		return "GameResultDTO [gameResult=" + gameResult + ", resultantNumber=" + resultantNumber
				+ ", finalUserBlockAmount=" + finalUserBlockAmount + ", finalUserAccountBalance="
				+ finalUserAccountBalance + "]";
	}

}
