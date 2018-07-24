package com.pragmaticplay.tictactoe.service;

import com.pragmaticplay.tictactoe.db.enums.Status;

public interface GameService {
	
	Status refreshStatus(Long gameId);

}
