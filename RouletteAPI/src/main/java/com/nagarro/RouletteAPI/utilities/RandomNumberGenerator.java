package com.nagarro.RouletteAPI.utilities;

public class RandomNumberGenerator {

	public static int randomNumberGenerator() {

		int randomNumber = (int) (Math.random() * 10000);

		int finalRandomNumber = randomNumber % 37;

		return finalRandomNumber;

	}

}
