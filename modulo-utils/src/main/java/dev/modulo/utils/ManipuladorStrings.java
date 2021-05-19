package dev.modulo.utils;

public class ManipuladorStrings {
	
	public static boolean isOnlyNumbers(String string) {
		if(string.matches("[0-9]+")) {
			return true;
		}
		return false;
	}

}
