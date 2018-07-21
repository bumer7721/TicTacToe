package com.pragmaticplay.tictactoe.db.dao.ipml;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.pragmaticplay.tictactoe.db.dao.GameDAO;
import com.pragmaticplay.tictactoe.db.entity.Game;
import com.pragmaticplay.tictactoe.db.entity.mapper.GameRowMapper;

@Repository
public class GameDAOImpl extends BaseDAOImpl implements GameDAO {
	
	private final static RowMapper<Game> MAPPER = new GameRowMapper();
	
	private final static String SELECT_ALL = "SELECT id, name, status FROM game";
	private final static String SELECT_BY_ID = SELECT_ALL + " WHERE id=?";
	private final static String CREATE_GAME = "INSERT INTO game (name, status) VALUES(?,?)";
	private final static String UPDATE_GAME = "UPDATE game SET name=?, status=? WHERE id=?";
	private final static String DELETE_GAME = "DELETE FROM game WHERE id=?";

	@Override
	public List<Game> getAll() {
		return jdbcTemplate.query(SELECT_ALL, MAPPER);
	}

	@Override
	public Game getById(Long id) {
		return jdbcTemplate.queryForObject(SELECT_BY_ID, MAPPER, id);
	}

	@Override
	public Long create(Game entity) {
		KeyHolder key = new GeneratedKeyHolder();
	    
	    jdbcTemplate.update((conn) -> {
	    	final PreparedStatement ps = conn.prepareStatement(CREATE_GAME, 
		            Statement.RETURN_GENERATED_KEYS);
		        ps.setString(1, entity.getName());
		        ps.setString(2, entity.getStatus().name());
		        return ps;
	    }, key);

	    return key.getKey().longValue();
	}

	@Override
	public void update(Game entity) {
		jdbcTemplate.update(UPDATE_GAME, entity.getName(), entity.getStatus().name(), entity.getId());
	}

	@Override
	public void delete(Long id) {
		jdbcTemplate.update(DELETE_GAME, id);
	}

}
