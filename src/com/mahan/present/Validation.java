package com.mahan.present;

public class Validation {
	public static boolean checkTextFieldString(String input) {

		return input.matches("[a-zA-Z _]+");
	}

	public static boolean checkTextFieldNumber(String input) {

		return input.matches("[0-9]+");
	}
	
	public static boolean checkTextField(String input) {

		return input.matches("[a-zA-Z _0-9@]+");
	}

}
