package com.nagarro.RouletteAPI.utilities;

public class PredictGameResult {

	public static boolean isGameWon(int numberChosen, int rouletteSpinResult) {

		boolean gameResult = false;

		switch (numberChosen) {
		case 1:
			if (1 <= rouletteSpinResult && rouletteSpinResult <= 12)
				gameResult = true;
			break;

		case 2:
			if (13 <= rouletteSpinResult && rouletteSpinResult <= 24)
				gameResult = true;
			break;

		case 3:
			if (25 <= rouletteSpinResult && rouletteSpinResult <= 36)
				gameResult = true;
			break;

		case 4:
			if (rouletteSpinResult == 0)
				gameResult = true;
			break;

		case 5:
			if (1 <= rouletteSpinResult && rouletteSpinResult <= 18)
				gameResult = true;
			break;

		case 6:
			if (19 <= rouletteSpinResult && rouletteSpinResult <= 36)
				gameResult = true;
			break;

		case 7:
			if (rouletteSpinResult % 2 == 0 && rouletteSpinResult != 0)
				gameResult = true;
			break;

		case 8:
			if (rouletteSpinResult % 2 != 0)
				gameResult = true;
			break;

		}
		return gameResult;
	}
}
