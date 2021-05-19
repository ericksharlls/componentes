package dev.modulo.service.interfaces;

import java.util.List;

import dev.modulo.abstractmodel.AbstractModel;
import dev.modulo.abstractmodel.RequestModel;
import dev.modulo.service.exception.NegocioException;

public interface IServiceConsultar<Model extends AbstractModel, R extends RequestModel> {

	public List<Model> consultar(R model) throws NegocioException;
	public void validar(R model) throws NegocioException;

}
