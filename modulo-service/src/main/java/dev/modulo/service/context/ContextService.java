package dev.modulo.service.context;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.modulo.abstractmodel.AbstractModel;
import dev.modulo.abstractmodel.PaginatedModel;
import dev.modulo.abstractmodel.RequestModel;
import dev.modulo.service.exception.NegocioException;
import dev.modulo.service.interfaces.IServiceConsultar;
import dev.modulo.service.interfaces.IServiceConsultarPaginado;
import dev.modulo.service.interfaces.IServiceObter;
import dev.modulo.service.interfaces.IServiceVoid;

@Component
public class ContextService {
	
	@Autowired
	private SpringContextUtil contextUtil;
	
	private Logger logger = Logger.getLogger(ContextService.class);
	
	public void processar(RequestModel requestModel) throws NegocioException {
		String serviceName = requestModel.getClass().getSimpleName();
		try {
			@SuppressWarnings("unchecked")
			IServiceVoid<RequestModel> service = (IServiceVoid<RequestModel>) this.contextUtil.getApplicationContext().getBean(serviceName);
			escreverLogInicializacao(serviceName);
			service.validar(requestModel);
			service.executar(requestModel);
			escreverLogFinalizacao(serviceName);
		} catch (NegocioException e) {
			lancarNegocioException(serviceName, e.getCodeErrorMessage());
		} catch (RuntimeException e) {
			lancarRuntimeException(serviceName, e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<? extends AbstractModel> consultarPaginado(PaginatedModel paginatedModel) throws NegocioException {
		List<AbstractModel> retorno = null;
		String serviceName = paginatedModel.getClass().getSimpleName();
		try {
			IServiceConsultarPaginado<AbstractModel, PaginatedModel> service = (IServiceConsultarPaginado<AbstractModel, PaginatedModel>) this.contextUtil.getApplicationContext().getBean(serviceName);
			escreverLogInicializacao(serviceName);
			service.validar(paginatedModel);
			retorno = (List<AbstractModel>) service.consultar(paginatedModel);
			escreverLogFinalizacao(serviceName);
		} catch (NegocioException e) {
			lancarNegocioException(serviceName, e.getCodeErrorMessage());
		} catch (RuntimeException e) {
			lancarRuntimeException(serviceName, e);
		}
		return retorno;
	}
	
	@SuppressWarnings("unchecked")
	public List<? extends AbstractModel> consultar(RequestModel requestModel) throws NegocioException {
		List<AbstractModel> retorno = null;
		String serviceName = requestModel.getClass().getSimpleName();
		try {
			IServiceConsultar<AbstractModel, RequestModel> service = (IServiceConsultar<AbstractModel, RequestModel>) this.contextUtil.getApplicationContext().getBean(serviceName);
			escreverLogInicializacao(serviceName);
			service.validar(requestModel);
			retorno = (List<AbstractModel>) service.consultar(requestModel);
			escreverLogFinalizacao(serviceName);
		} catch (NegocioException e) {
			lancarNegocioException(serviceName, e.getCodeErrorMessage());
		} catch (RuntimeException e) {
			lancarRuntimeException(serviceName, e);
		}
		return retorno;
	}
	
	public Integer contar(PaginatedModel paginatedModel) throws NegocioException {
		Integer contador = 0;
		String serviceName = paginatedModel.getClass().getSimpleName();
		try {
			@SuppressWarnings("unchecked")
			IServiceConsultarPaginado<AbstractModel, PaginatedModel> service = (IServiceConsultarPaginado<AbstractModel, PaginatedModel>) this.contextUtil.getApplicationContext().getBean(serviceName);
			escreverLogInicializacao(serviceName);
			contador = service.contar(paginatedModel);
			escreverLogFinalizacao(serviceName);
		} catch (NegocioException e) {
			lancarNegocioException(serviceName, e.getCodeErrorMessage());
		} catch (RuntimeException e) {
			lancarRuntimeException(serviceName, e);
		}
		return contador;
	}
	
	public AbstractModel obter(RequestModel requestModel) throws NegocioException {
		AbstractModel retorno = null;
		String serviceName = requestModel.getClass().getSimpleName();
		try {
			@SuppressWarnings("unchecked")
			IServiceObter<AbstractModel, RequestModel> service = (IServiceObter<AbstractModel, RequestModel>) this.contextUtil.getApplicationContext().getBean(serviceName);
			escreverLogInicializacao(serviceName);
			retorno = service.obter(requestModel);
			escreverLogFinalizacao(serviceName);
		} catch (NegocioException e) {
			lancarNegocioException(serviceName, e.getCodeErrorMessage());
		} catch (RuntimeException e) {
			lancarRuntimeException(serviceName, e);
		}
		return retorno;
	}
	
	private void lancarNegocioException(String serviceName, String codeErrorMessage) throws NegocioException {
		logger.info("Execução do serviço '" + serviceName + "' finalizada com problema. Mensagem: " + codeErrorMessage);
		throw new NegocioException(codeErrorMessage);
	}
	
	private void lancarRuntimeException(String serviceName, RuntimeException runtimeException) throws NegocioException {
		runtimeException.printStackTrace();
		logger.info("Execução do serviço '" + serviceName + "' finalizada com problema. Mensagem: " + runtimeException.getMessage());
		throw new NegocioException("1000");
	}
	
	private void escreverLogInicializacao(String serviceName) {
		logger.info("Execução do serviço '" + serviceName + "' iniciada!");
	}
	
	private void escreverLogFinalizacao(String serviceName) {
		logger.info("Execução do serviço '" + serviceName + "' finalizada com sucesso!");
	}

}
