package com.nagarro.RouletteAPI.utilities;

public class RandomNumberGenerator {

	/**
	 * This function generates the random number as the roulette result.
	 * 
	 * @return
	 */
	public static int randomNumberGenerator() {

		int randomNumber1 = (int) (Math.random() * 100000);
		int randomNumber2 = (int) (Math.random() * 100000);

		int randomNumber3 = randomNumber1 + randomNumber2;

//		System.out.println(randomNumber3);
		return randomNumber3 % 37;
	}

}
