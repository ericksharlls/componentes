package dev.modulo.service.exception;

public class NegocioException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private String codeErrorMessage;
	
	public NegocioException(String codeErrorMessage) {
	    setCodeErrorMessage(codeErrorMessage);
	 }

	public String getCodeErrorMessage() {
		return codeErrorMessage;
	}

	public void setCodeErrorMessage(String codeErrorMessage) {
		this.codeErrorMessage = codeErrorMessage;
	}

}
