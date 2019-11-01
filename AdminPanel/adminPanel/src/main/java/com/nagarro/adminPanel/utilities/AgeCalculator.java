package com.nagarro.adminPanel.utilities;

import java.time.LocalDate;
import java.time.Period;

public class AgeCalculator {

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
