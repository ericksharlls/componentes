package dev.modulo.web;

import java.util.ResourceBundle;

public class FindMessage {
	
	public static String getMessage(String propertiesFilePath, String codeErrorMessage) {
		ResourceBundle property = ResourceBundle.getBundle(propertiesFilePath);
		return property.getString(codeErrorMessage);
	}

}
