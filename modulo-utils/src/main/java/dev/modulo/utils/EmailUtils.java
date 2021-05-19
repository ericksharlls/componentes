package dev.modulo.utils;

import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailUtils {

	private static String REGEX_EMAIL = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,6})$";

	public static boolean validarEmail(String email) throws ParseException {
		Pattern padrao = Pattern.compile(REGEX_EMAIL);
		Matcher pesquisa = padrao.matcher(email);
		if (pesquisa.matches()) {
			return true;
		}
		return false;
	}

}
