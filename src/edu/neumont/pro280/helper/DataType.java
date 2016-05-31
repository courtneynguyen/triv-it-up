package edu.neumont.pro280.helper;

public class DataType {

	public static int createInteger(String s) {
		int toReturn = 0;
		try {
			Integer.parseInt(s);
			toReturn = Integer.parseInt(s);
		} catch (NumberFormatException e) {

		}
		// only got here if we didn't return false
		return toReturn;
	}

	public static double isDouble(String s) {
		double toReturn = 0;
		try {
			Double.parseDouble(s);
			toReturn = Double.parseDouble(s);
		} catch (NumberFormatException e) {

		}
		// only got here if we didn't return false
		return toReturn;
	}
}
