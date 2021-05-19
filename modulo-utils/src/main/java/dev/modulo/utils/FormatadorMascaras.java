package dev.modulo.utils;

import java.text.ParseException;

import javax.swing.text.MaskFormatter;

public class FormatadorMascaras {

	public static String aplicarMascaraCPF(String campo) throws ParseException {
	      MaskFormatter mf = new MaskFormatter("###.###.###-##");
	      mf.setValueContainsLiteralCharacters(false);
	      return mf.valueToString(campo);
	   }

	   public static String aplicarMascaraTelefoneSemDDD(String campo) throws ParseException {
	      MaskFormatter mf = new MaskFormatter("#####-####");
	      mf.setValueContainsLiteralCharacters(false);
	      return mf.valueToString(campo);
	   }

	   public static String aplicarMascaraTelefoneComDDD(String campo) throws ParseException {
	      MaskFormatter mf = new MaskFormatter("(##) #####-####");
	      mf.setValueContainsLiteralCharacters(false);
	      return mf.valueToString(campo);
	   }

	   public static String removerMascaraCPF(String campo) throws ParseException {
	      return campo.replaceAll("[.-]", "");
	   }

	   public static String removerMascaraTelefone(String campo) throws ParseException {
	      return campo.replaceAll("[-]", "");
	   }
	   
	   public static String removerMascaraTelefoneComDDD(String campo) throws ParseException {
		      return campo.replaceAll("[-() ]", "");
		   }
	
}
