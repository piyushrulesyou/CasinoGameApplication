package com.nagarro.RouletteAPI.utilities;

public class SegmentToNumberChosenRoulette {

	public static int convertSegmentToNumber(String segmentChosen) {

		if (("first12").equalsIgnoreCase(segmentChosen))
			return 1;

		if (("second12").equalsIgnoreCase(segmentChosen))
			return 2;

		if (("last12").equalsIgnoreCase(segmentChosen))
			return 3;

		if (("zero").equalsIgnoreCase(segmentChosen))
			return 4;

		if (("first18").equalsIgnoreCase(segmentChosen))
			return 5;

		if (("last18").equalsIgnoreCase(segmentChosen))
			return 6;

		if (("even").equalsIgnoreCase(segmentChosen))
			return 7;

		if (("odd").equalsIgnoreCase(segmentChosen))
			return 8;

		return 0;
	}
}
