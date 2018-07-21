package com.pragmaticplay.tictactoe.db.entity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pragmaticplay.tictactoe.db.entity.Step;

public class StepRowMapper implements RowMapper<Step> {

	@Override
	public Step mapRow(ResultSet rs, int rowNum) throws SQLException {
		Long id = rs.getLong("id");
		Long gameId = rs.getLong("game_id");
		Integer numberOfGame = rs.getInt("number_of_step");  
		Integer x = rs.getInt("x");  
		Integer y = rs.getInt("y");  
		return new Step(id, gameId, numberOfGame, x, y);
	}

}
