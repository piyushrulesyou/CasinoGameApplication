package com.nagarro.RouletteAPI.utilities;

public class RandomNumberGenerator {

	/**
	 * This function generates the random number as the roulette result.
	 * 
	 * @return
	 */
	public static int randomNumberGenerator() {

		int randomNumber = generateRouletteNumber();
//		System.out.println(randomNumber);
		return randomNumber;
	}

	private static int generateRouletteNumber() {
		int rounds = 20;
		int noOfDigits;
		int random;
		int[] randoms = new int[rounds];

		while (rounds-- > 0) {
			noOfDigits = (int) (Math.random() * 10);
			random = (int) (Math.random() * (Math.pow(10, noOfDigits)));
			randoms[rounds] = random;
		}

		return getRandom(randoms) % 37;

	}

	private static int getRandom(int[] arr) {
		int maxLength = arr.length % 2 == 0 ? arr.length / 2 + 1 : arr.length / 2 + 2;
		return getRandom(arr, maxLength, 0, 0, 0, 0, 0);
	}

	private static int getRandom(int[] arr, int maxLength, int index, int length1, int sum1, int length2, int sum2) {

		if (length1 == maxLength || length2 == maxLength) {
			return Integer.MAX_VALUE;
		}

		if (index == arr.length) {

			if (Math.abs(length2 - length1) < 2) {
				return Math.abs(sum1 - sum2);
			}

			return Integer.MAX_VALUE;
		}

		return Math.min(getRandom(arr, maxLength, index + 1, length1 + 1, sum1 + arr[index], length2, sum2),
				getRandom(arr, maxLength, index + 1, length1, sum1, length2 + 1, sum2 + arr[index]));
	}
}
