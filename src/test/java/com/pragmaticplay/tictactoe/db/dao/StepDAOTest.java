package com.pragmaticplay.tictactoe.db.dao;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.pragmaticplay.tictactoe.db.SpringTest;
import com.pragmaticplay.tictactoe.db.entity.Step;

public class StepDAOTest extends SpringTest {
	
	@Autowired
	private StepDAO stepDAO;
	
	@Test
	public void getAll() {
		List<Step> games = stepDAO.getAll();
		assertThat(games, notNullValue());
		assertThat(games, hasSize(3));
	}
	
	@Test
	public void getById() {
		Step game = stepDAO.getById(1L);
		assertThat(game, notNullValue());
		assertThat(game.getId(), equalTo(1L));
	}
	
	@Test
	public void create() {
		Step step = new Step(2L, 0, 0, 0);
		Long newStatusId = stepDAO.create(step);
		assertThat(newStatusId, notNullValue());
		assertThat(newStatusId, equalTo(100L));
		
		Step newStep = stepDAO.getById(newStatusId);
		assertThat(newStep, notNullValue());
		assertThat(newStep.getGameId(), equalTo(step.getGameId()));
		assertThat(newStep.getNumberOfStep(), equalTo(step.getNumberOfStep()));
		assertThat(newStep.getX(), equalTo(step.getX()));
		assertThat(newStep.getY(), equalTo(step.getY()));
	}
	
	@Test
	public void update() {
		Step step = stepDAO.getById(1L); 
		step.setX(1);
		step.setY(0);
		
		stepDAO.update(step);
		Step updatedStep = stepDAO.getById(step.getId());
		assertThat(updatedStep, notNullValue());
		assertThat(updatedStep.getId(), equalTo(step.getId()));
		assertThat(updatedStep.getNumberOfStep(), equalTo(step.getNumberOfStep()));
		assertThat(updatedStep.getX(), equalTo(step.getX()));
		assertThat(updatedStep.getY(), equalTo(step.getY()));
	}
	
	@Test
	public void delete() {
		stepDAO.delete(1L);
		assertThat(stepDAO.getAll(), hasSize(2));
	}
}
