package com.pragmaticplay.tictactoe.service;

import com.pragmaticplay.tictactoe.db.entity.Step;
import com.pragmaticplay.tictactoe.db.enums.Status;

public interface StepService {
	
	Status newStepAndRefreshStatus(Step step);

}
