package com.pragmaticplay.tictactoe.db.dao;

import com.pragmaticplay.tictactoe.db.entity.Game;
import com.pragmaticplay.tictactoe.db.enums.Status;

public interface GameDAO extends BaseDAO<Game> {
	
	void udateStatus(Long gameId, Status status);

}
