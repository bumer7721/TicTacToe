package com.pragmaticplay.tictactoe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pragmaticplay.tictactoe.db.dao.StepDAO;
import com.pragmaticplay.tictactoe.db.entity.Step;
import com.pragmaticplay.tictactoe.db.enums.Status;
import com.pragmaticplay.tictactoe.service.GameService;
import com.pragmaticplay.tictactoe.service.StepService;

@Service
public class StepServiceImpl implements StepService {
	
	@Autowired
	private StepDAO stepDAO;
	
	@Autowired
	private GameService gameService;

	@Override
	@Transactional
	public Status newStepAndRefreshStatus(Step step) {
		stepDAO.create(step);
		return gameService.refreshStatus(step.getGameId());
	}

}
