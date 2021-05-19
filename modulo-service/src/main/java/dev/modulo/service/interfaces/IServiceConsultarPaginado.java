package dev.modulo.service.interfaces;

import java.util.List;

import dev.modulo.abstractmodel.AbstractModel;
import dev.modulo.abstractmodel.PaginatedModel;
import dev.modulo.service.exception.NegocioException;

public interface IServiceConsultarPaginado<Model extends AbstractModel, PaginatedObject extends PaginatedModel> {

	public List<Model> consultar(PaginatedObject paginatedModel) throws NegocioException;
	public void validar(PaginatedObject paginatedModel) throws NegocioException;
	public Integer contar(PaginatedObject paginatedObject) throws NegocioException;
	
}
