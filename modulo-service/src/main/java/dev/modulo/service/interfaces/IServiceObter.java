package dev.modulo.service.interfaces;

import dev.modulo.abstractmodel.AbstractModel;
import dev.modulo.abstractmodel.RequestModel;
import dev.modulo.service.exception.NegocioException;

public interface IServiceObter<Model extends AbstractModel, R extends RequestModel> {
	
	public Model obter(R request) throws NegocioException;

}
