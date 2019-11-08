package com.nagarro.adminPanel.utilities;

import java.time.LocalDate;
import java.time.Period;

/**
 * This class is used for calculating the present age of the user on the basis
 * of user's DOB
 * 
 * @author piyushagarwal01
 *
 */
public class AgeCalculator {

	/**
	 * This method compares the customer DOB with localDate
	 * 
	 * @param customerDOB
	 * @return true if customer is 18+ years.
	 */
	public static boolean isValidAge(String customerDOB) {

		LocalDate customerDob = DateParser.getDate(customerDOB);

		LocalDate todayDate = LocalDate.now();

		Period agePeriod = Period.between(customerDob, todayDate);

		int customerAge = agePeriod.getYears();

		if (customerAge >= 18)
			return true;

		else
			return false;

	}

}
