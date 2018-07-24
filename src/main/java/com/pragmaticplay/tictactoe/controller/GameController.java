package com.pragmaticplay.tictactoe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pragmaticplay.tictactoe.db.dao.GameDAO;
import com.pragmaticplay.tictactoe.db.entity.Game;
import com.pragmaticplay.tictactoe.db.enums.Status;

@RestController
@RequestMapping("game/")
public class GameController {
	
	@Autowired
	private GameDAO gameDAO;
	
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Game> getAll() {
		return gameDAO.getAll();
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Game getById(@PathVariable Long id) {
		return gameDAO.getById(id);
	}
	
	@PostMapping(value = "/new", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Game newGame(@RequestBody Game newGame) {
		newGame.setStatus(Status.IN_PROGRESS);
		Long newGameId = gameDAO.create(newGame);
		return gameDAO.getById(newGameId);
	}
}