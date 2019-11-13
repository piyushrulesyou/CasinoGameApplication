package com.nagarro.adminPanel.utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomID {

	private int generateRandom(int num) {
		List<Integer> evenNumberList = new ArrayList<>();
		List<Integer> oddNumbersList = new ArrayList<>();

		fillList(evenNumberList, oddNumbersList, num);
		int result = 0;
		for (int i = 0; i < evenNumberList.size(); i++) {
			if (evenNumberList.get(i) >= 0) {
				result += evenNumberList.get(i);
			}
		}

		Collections.sort(oddNumbersList);
		result += oddNumbersList.get(oddNumbersList.size() - 1);
		oddNumbersList.remove(oddNumbersList.size() - 1);

		for (int i = 0; i < evenNumberList.size(); ++i) {
			if (evenNumberList.get(i) < 0) {
				result += (evenNumberList.get(i) * -1);
			}
		}

		boolean isPositive = false;

		while (oddNumbersList.size() > 0) {
			if (isPositive) {
				result += oddNumbersList.get(oddNumbersList.size() - 1);
				oddNumbersList.remove(oddNumbersList.size() - 1);
			} else {
				result += (-1 * oddNumbersList.get(0));
				oddNumbersList.remove(0);
			}
			isPositive = !isPositive;
		}

		result = result * -1;
		while (result < 0) {
			result += 37;
		}
		result = result % 37;
		return result;
	}

	private void fillList(List<Integer> even, List<Integer> odd, int n) {
		Random randomNumber = new Random();
		for (int i = 0; i < n; i++) {

			int digit = randomNumber.nextInt(10) + 1;

			int evenSum = 0;
			int oddSum = 0;

			for (int j = 1; j <= digit; ++j) {
				int x = randomNumber.nextInt(10);
				if (j % 2 == 0) {
					evenSum += x;
				} else {
					oddSum += x;
				}
			}

			if (digit % 2 == 0) {
				even.add(evenSum - oddSum);
			} else {
				odd.add(evenSum - oddSum);
			}
		}
	}
}