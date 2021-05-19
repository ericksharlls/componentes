package dev.modulo.service.interfaces;

import dev.modulo.abstractmodel.RequestModel;
import dev.modulo.service.exception.NegocioException;

public interface IServiceVoid<Model extends RequestModel> {

	public void executar(Model requestModel) throws NegocioException;
	public void validar(Model requestModel) throws NegocioException;
	
}
