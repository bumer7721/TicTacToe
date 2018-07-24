package com.pragmaticplay.tictactoe.db.dao;

import java.util.List;

import com.pragmaticplay.tictactoe.db.entity.Step;

public interface StepDAO extends BaseDAO<Step> {
	
	List<Step> getStepsByGame(Long idGame);

}
