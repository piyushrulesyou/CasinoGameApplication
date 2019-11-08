package com.nagarro.RouletteAPI.dto;

/**
 * This class contains the final account balance after the roulette game has
 * been played. This final is to be updated in the database.
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
