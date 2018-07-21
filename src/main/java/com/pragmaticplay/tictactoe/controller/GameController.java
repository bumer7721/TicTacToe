package com.pragmaticplay.tictactoe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pragmaticplay.tictactoe.db.dao.GameDAO;
import com.pragmaticplay.tictactoe.db.entity.Game;

@RestController
public class GameController {
	
	@Autowired
	private GameDAO gameDAO;
	
	@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Game> getAll() {
		return gameDAO.getAll();
	}

}
