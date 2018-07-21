package com.pragmaticplay.tictactoe.db.dao.ipml;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.pragmaticplay.tictactoe.db.dao.StepDAO;
import com.pragmaticplay.tictactoe.db.entity.Step;
import com.pragmaticplay.tictactoe.db.entity.mapper.StepRowMapper;

@Repository
public class StepDAOImpl extends BaseDAOImpl implements StepDAO {
	
	private final static RowMapper<Step> MAPPER = new StepRowMapper();
	
	private final static String SELECT_ALL = "SELECT id, game_id, number_of_step, x, y FROM step";
	private final static String SELECT_BY_ID = SELECT_ALL + " WHERE id=?";
	private final static String CREATE_STEP = "INSERT INTO step (game_id, number_of_step, x, y) VALUES(?,?,?,?)";
	private final static String UPDATE_STEP = "UPDATE step SET game_id=?, number_of_step=?, x=?, y=? WHERE id=?";
	private final static String DELETE_STEP = "DELETE FROM step WHERE id=?";

	@Override
	public List<Step> getAll() {
		return jdbcTemplate.query(SELECT_ALL, MAPPER);
	}

	@Override
	public Step getById(Long id) {
		return jdbcTemplate.queryForObject(SELECT_BY_ID, MAPPER, id);
	}

	@Override
	public Long create(Step entity) {
		KeyHolder key = new GeneratedKeyHolder();
	    
	    jdbcTemplate.update((conn) -> {
	    	final PreparedStatement ps = conn.prepareStatement(CREATE_STEP, 
		            Statement.RETURN_GENERATED_KEYS);
		        ps.setLong(1, entity.getGameId());
		        ps.setInt(2, entity.getNumberOfStep());
		        ps.setInt(3, entity.getX());
		        ps.setInt(4, entity.getY());
		        return ps;
	    }, key);

	    return key.getKey().longValue();
	}

	@Override
	public void update(Step entity) {
		jdbcTemplate.update(UPDATE_STEP, entity.getGameId(), entity.getNumberOfStep(), entity.getX(), entity.getY(), entity.getId());
	}

	@Override
	public void delete(Long id) {
		jdbcTemplate.update(DELETE_STEP, id);
	}

}
