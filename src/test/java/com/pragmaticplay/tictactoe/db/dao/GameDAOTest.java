package com.pragmaticplay.tictactoe.db.dao;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.pragmaticplay.tictactoe.db.SpringTest;
import com.pragmaticplay.tictactoe.db.entity.Game;
import com.pragmaticplay.tictactoe.db.enums.Status;

public class GameDAOTest extends SpringTest {
	
	@Autowired
	private GameDAO gameDAO;
	
	@Autowired
	private StepDAO stepDAO;
	
	@Test
	public void getAll() {
		List<Game> games = gameDAO.getAll();
		assertThat(games, notNullValue());
		assertThat(games, hasSize(2));
	}
	
	@Test
	public void getById() {
		Game game = gameDAO.getById(1L);
		assertThat(game, notNullValue());
		assertThat(game.getId(), equalTo(1L));
	}
	
	@Test
	public void create() {
		Game game = new Game("My new game", Status.IN_PROGRESS);
		Long newGameId = gameDAO.create(game);
		assertThat(newGameId, notNullValue());
		assertThat(newGameId, equalTo(100L));
		
		Game newGame = gameDAO.getById(newGameId);
		assertThat(newGame, notNullValue());
		assertThat(newGame.getName(), equalTo(game.getName()));
		assertThat(newGame.getStatus(), equalTo(game.getStatus()));
	}
	
	@Test
	public void update() {
		Game game = gameDAO.getById(1L); 
		game.setName("Updated name");
		game.setStatus(Status.DRAW);
		
		gameDAO.update(game);
		Game updatedGame = gameDAO.getById(game.getId());
		assertThat(updatedGame, notNullValue());
		assertThat(updatedGame.getName(), equalTo(game.getName()));
		assertThat(updatedGame.getStatus(), equalTo(game.getStatus()));
	}
	
	@Test
	public void delete() {
		gameDAO.delete(1L);
		assertThat(gameDAO.getAll(), hasSize(1));
		// All the steps must be deleted for the game is deleted 
		assertThat(stepDAO.getAll(), hasSize(0));
	}
}
