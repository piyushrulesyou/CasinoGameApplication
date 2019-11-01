package com.nagarro.adminPanel.utilities;

public class GenerateRandomID {

	public static String generateID(String emailID, String contactNumber, String customerName) {

		String firstPart = emailID.substring(0, 3).toLowerCase();

		int randOne = (int) (Math.random() * 100);

		String secondPart = contactNumber.substring(0, 3);

		int randTwo = (int) (Math.random() * 100);

		String thirdPart = customerName.substring(0, 3).toLowerCase();

		int randThree = (int) (Math.random() * 100);

		String finalID = firstPart + randOne + secondPart + randTwo + thirdPart + randThree;

		return finalID;
	}

}
