package dev.modulo.persistence.dao;

import java.io.Serializable;
import java.util.List;

public interface Dao<PK extends Serializable, T> {
	
	public T getById(PK id);
	
	public void persist(T entity);
	
	public void update(T entity);
	
	public void delete(T entity);
	
	public void delete(PK id);
	
	public List<T> findAll();
	
	public List<T> findAllPaginated(Integer startPosition, Integer maxResult);
	
	public Long countAll();

}
