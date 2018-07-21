package com.pragmaticplay.tictactoe.db.entity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pragmaticplay.tictactoe.db.entity.Game;
import com.pragmaticplay.tictactoe.db.enums.Status;

public class GameRowMapper implements RowMapper<Game> {

	@Override
	public Game mapRow(ResultSet rs, int rowNum) throws SQLException {
		Long id = rs.getLong("id");
		String name = rs.getString("name");
		Status status = Status.valueOf(rs.getString("status"));
		return new Game(id, name, status);
	}

}
