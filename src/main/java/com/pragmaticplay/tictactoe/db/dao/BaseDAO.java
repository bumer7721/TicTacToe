package com.pragmaticplay.tictactoe.db.dao;

import java.util.List;

public interface BaseDAO<E> {
	
	List<E> getAll();
	
	E getById(Long id);
	
	Long create(E entity);
	
	void update(E entity);
	
	void delete(Long id);

}
