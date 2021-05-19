package dev.modulo.web;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public abstract class AbstractFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	protected void addErrorMessage(String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, mensagem));
	}

	protected void addInfoMessage(String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, mensagem));
	}
	
	protected void addInfoMessageByCodeMessage(String codeInfoMessage) {
		String mensagem = FindMessage.getMessage(getMessagesPropertiesFilePath(), codeInfoMessage);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, mensagem));
	}
	
	protected void addErrorMessageByCodeMessage(String codeErrorMessage) {
		String mensagem = FindMessage.getMessage(getMessagesPropertiesFilePath(), codeErrorMessage);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, mensagem));
	}
	
	protected String getMessageByCodeMessage(String codeErrorMessage) {
		String mensagem = FindMessage.getMessage(getMessagesPropertiesFilePath(), codeErrorMessage);
		return mensagem;
	}
	
	protected String getParameterByCodeParameter(String codeParameter) {
		String mensagem = FindMessage.getMessage(getParametersPropertiesFilePath(), codeParameter);
		return mensagem;
	}

	protected abstract String getMessagesPropertiesFilePath();
	
	protected abstract String getParametersPropertiesFilePath();
	
}
