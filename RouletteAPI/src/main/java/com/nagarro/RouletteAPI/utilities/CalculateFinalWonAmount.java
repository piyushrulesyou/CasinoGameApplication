package com.nagarro.RouletteAPI.utilities;

public class CalculateFinalWonAmount {

	/**
	 * This method calculates the amount the user has won or lose after the random
	 * number is generated based on the user selected segment.
	 * 
	 * @param blockAmount
	 * @param numberChosen
	 * @return The final amount the user has won or lose.
	 */
	public static double calculateFinalWonAmount(double blockAmount, int numberChosen) {

		switch (numberChosen) {
		case 1:
			blockAmount = blockAmount * 1.5;
			break;
		case 2:
			blockAmount = blockAmount * 1.5;
			break;
		case 3:
			blockAmount = blockAmount * 1.5;
			break;

		case 4:
			blockAmount = blockAmount * 10;
			break;
		case 5:
			blockAmount = blockAmount * 1.25;
			break;
		case 6:
			blockAmount = blockAmount * 1.25;
			break;
		case 7:
			blockAmount = blockAmount * 1.25;
			break;
		case 8:
			blockAmount = blockAmount * 1.25;
			break;

		}
		return blockAmount;
	}
}
