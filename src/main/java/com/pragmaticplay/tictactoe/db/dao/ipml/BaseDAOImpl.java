package com.pragmaticplay.tictactoe.db.dao.ipml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class BaseDAOImpl {
	
	@Autowired
	protected JdbcTemplate jdbcTemplate;

}
