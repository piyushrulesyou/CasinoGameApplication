package com.nagarro.RouletteAPI.utilities;

public class CalculateFinalWonAmount {

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
