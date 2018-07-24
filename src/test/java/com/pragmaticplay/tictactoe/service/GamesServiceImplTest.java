package com.pragmaticplay.tictactoe.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.pragmaticplay.tictactoe.SpringTest;
import com.pragmaticplay.tictactoe.db.dao.StepDAO;
import com.pragmaticplay.tictactoe.db.entity.Step;
import com.pragmaticplay.tictactoe.db.enums.Status;

public class GamesServiceImplTest extends SpringTest {
	@MockBean
	private StepDAO stepDAO;

	@Autowired
	private GameService gameService;
	
	//rows X won 
	@Test
	public void refreshStatus_1_row_x_won() {
		List<Step> steps = new ArrayList<>();
		steps.add(new Step(1L, 1, 1, 1));
		steps.add(new Step(1L, 2, 2, 2));
		steps.add(new Step(1L, 3, 1, 2));
		steps.add(new Step(1L, 4, 2, 3));
		steps.add(new Step(1L, 5, 1, 3));
		
		Mockito.when(stepDAO.getStepsByGame(Mockito.anyLong())).thenReturn(steps);
		Status status = gameService.refreshStatus(1L);
		
		assertThat(status, equalTo(Status.X_WON));
	}
	
	@Test
	public void refreshStatus_2_row_x_won() {
		List<Step> steps = new ArrayList<>();
		steps.add(new Step(1L, 1, 2, 1));
		steps.add(new Step(1L, 2, 1, 2));
		steps.add(new Step(1L, 3, 2, 2));
		steps.add(new Step(1L, 4, 1, 3));
		steps.add(new Step(1L, 5, 2, 3));
		
		Mockito.when(stepDAO.getStepsByGame(Mockito.anyLong())).thenReturn(steps);
		Status status = gameService.refreshStatus(1L);
		
		assertThat(status, equalTo(Status.X_WON));
	}
	
	@Test
	public void refreshStatus_3_row_x_won() {
		List<Step> steps = new ArrayList<>();
		steps.add(new Step(1L, 1, 3, 1));
		steps.add(new Step(1L, 2, 1, 2));
		steps.add(new Step(1L, 3, 3, 2));
		steps.add(new Step(1L, 4, 1, 3));
		steps.add(new Step(1L, 5, 3, 3));
		
		Mockito.when(stepDAO.getStepsByGame(Mockito.anyLong())).thenReturn(steps);
		Status status = gameService.refreshStatus(1L);
		
		assertThat(status, equalTo(Status.X_WON));
	}
	
	//rows O won 
	@Test
	public void refreshStatus_1_row_o_won() {
		List<Step> steps = new ArrayList<>();
		steps.add(new Step(1L, 1, 2, 1));
		steps.add(new Step(1L, 2, 1, 2));
		steps.add(new Step(1L, 3, 2, 2));
		steps.add(new Step(1L, 4, 1, 3));
		steps.add(new Step(1L, 5, 3, 3));
		steps.add(new Step(1L, 6, 1, 1));
		
		Mockito.when(stepDAO.getStepsByGame(Mockito.anyLong())).thenReturn(steps);
		Status status = gameService.refreshStatus(1L);
		
		assertThat(status, equalTo(Status.O_WON));
	}
	
	@Test
	public void refreshStatus_2_row_o_won() {
		List<Step> steps = new ArrayList<>();
		steps.add(new Step(1L, 1, 1, 1));
		steps.add(new Step(1L, 2, 2, 2));
		steps.add(new Step(1L, 3, 1, 2));
		steps.add(new Step(1L, 4, 2, 3));
		steps.add(new Step(1L, 5, 3, 3));
		steps.add(new Step(1L, 6, 2, 1));
		
		Mockito.when(stepDAO.getStepsByGame(Mockito.anyLong())).thenReturn(steps);
		Status status = gameService.refreshStatus(1L);
		
		assertThat(status, equalTo(Status.O_WON));
	}
	
	@Test
	public void refreshStatus_3_row_o_won() {
		List<Step> steps = new ArrayList<>();
		steps.add(new Step(1L, 1, 1, 1));
		steps.add(new Step(1L, 2, 3, 2));
		steps.add(new Step(1L, 3, 2, 2));
		steps.add(new Step(1L, 4, 3, 3));
		steps.add(new Step(1L, 5, 1, 3));
		steps.add(new Step(1L, 6, 3, 1));
		
		Mockito.when(stepDAO.getStepsByGame(Mockito.anyLong())).thenReturn(steps);
		Status status = gameService.refreshStatus(1L);
		
		assertThat(status, equalTo(Status.O_WON));
	}
	
	//cols X won 
	@Test
	public void refreshStatus_1_col_x_won() {
		List<Step> steps = new ArrayList<>();
		steps.add(new Step(1L, 1, 1, 1));
		steps.add(new Step(1L, 2, 2, 2));
		steps.add(new Step(1L, 3, 2, 1));
		steps.add(new Step(1L, 4, 2, 3));
		steps.add(new Step(1L, 5, 3, 1));
		
		Mockito.when(stepDAO.getStepsByGame(Mockito.anyLong())).thenReturn(steps);
		Status status = gameService.refreshStatus(1L);
		
		assertThat(status, equalTo(Status.X_WON));
	}
	
	@Test
	public void refreshStatus_2_col_x_won() {
		List<Step> steps = new ArrayList<>();
		steps.add(new Step(1L, 1, 1, 2));
		steps.add(new Step(1L, 2, 1, 1));
		steps.add(new Step(1L, 3, 2, 2));
		steps.add(new Step(1L, 4, 1, 3));
		steps.add(new Step(1L, 5, 3, 2));
		
		Mockito.when(stepDAO.getStepsByGame(Mockito.anyLong())).thenReturn(steps);
		Status status = gameService.refreshStatus(1L);
		
		assertThat(status, equalTo(Status.X_WON));
	}
	
	@Test
	public void refreshStatus_3_col_x_won() {
		List<Step> steps = new ArrayList<>();
		steps.add(new Step(1L, 1, 1, 3));
		steps.add(new Step(1L, 2, 1, 2));
		steps.add(new Step(1L, 3, 2, 3));
		steps.add(new Step(1L, 4, 1, 1));
		steps.add(new Step(1L, 5, 3, 3));
		
		Mockito.when(stepDAO.getStepsByGame(Mockito.anyLong())).thenReturn(steps);
		Status status = gameService.refreshStatus(1L);
		
		assertThat(status, equalTo(Status.X_WON));
	}
	
	//cols O won 
	@Test
	public void refreshStatus_1_col_o_won() {
		List<Step> steps = new ArrayList<>();
		steps.add(new Step(1L, 1, 2, 3));
		steps.add(new Step(1L, 2, 1, 1));
		steps.add(new Step(1L, 3, 2, 2));
		steps.add(new Step(1L, 4, 3, 1));
		steps.add(new Step(1L, 5, 3, 3));
		steps.add(new Step(1L, 6, 2, 1));
		
		Mockito.when(stepDAO.getStepsByGame(Mockito.anyLong())).thenReturn(steps);
		Status status = gameService.refreshStatus(1L);
		
		assertThat(status, equalTo(Status.O_WON));
	}
	
	@Test
	public void refreshStatus_2_col_o_won() {
		List<Step> steps = new ArrayList<>();
		steps.add(new Step(1L, 1, 1, 1));
		steps.add(new Step(1L, 2, 2, 2));
		steps.add(new Step(1L, 3, 1, 3));
		steps.add(new Step(1L, 4, 3, 2));
		steps.add(new Step(1L, 5, 3, 3));
		steps.add(new Step(1L, 6, 1, 2));
		
		Mockito.when(stepDAO.getStepsByGame(Mockito.anyLong())).thenReturn(steps);
		Status status = gameService.refreshStatus(1L);
		
		assertThat(status, equalTo(Status.O_WON));
	}
	
	@Test
	public void refreshStatus_3_col_o_won() {
		List<Step> steps = new ArrayList<>();
		steps.add(new Step(1L, 1, 1, 1));
		steps.add(new Step(1L, 2, 2, 3));
		steps.add(new Step(1L, 3, 2, 2));
		steps.add(new Step(1L, 4, 3, 3));
		steps.add(new Step(1L, 5, 1, 2));
		steps.add(new Step(1L, 6, 1, 3));
		
		Mockito.when(stepDAO.getStepsByGame(Mockito.anyLong())).thenReturn(steps);
		Status status = gameService.refreshStatus(1L);
		
		assertThat(status, equalTo(Status.O_WON));
	}
	
	// diag
	@Test
	public void refreshStatus_Diag_x_won() {
		List<Step> steps = new ArrayList<>();
		steps.add(new Step(1L, 1, 1, 1));
		steps.add(new Step(1L, 2, 2, 3));
		steps.add(new Step(1L, 3, 2, 2));
		steps.add(new Step(1L, 4, 1, 3));
		steps.add(new Step(1L, 5, 3, 3));
		
		Mockito.when(stepDAO.getStepsByGame(Mockito.anyLong())).thenReturn(steps);
		Status status = gameService.refreshStatus(1L);
		
		assertThat(status, equalTo(Status.X_WON));
	}
	
	@Test
	public void refreshStatus_Diag_o_won() {
		List<Step> steps = new ArrayList<>();
		steps.add(new Step(1L, 1, 2, 1));
		steps.add(new Step(1L, 2, 1, 1));
		steps.add(new Step(1L, 3, 1, 2));
		steps.add(new Step(1L, 4, 2, 2));
		steps.add(new Step(1L, 5, 3, 2));
		steps.add(new Step(1L, 6, 3, 3));
		
		Mockito.when(stepDAO.getStepsByGame(Mockito.anyLong())).thenReturn(steps);
		Status status = gameService.refreshStatus(1L);
		
		assertThat(status, equalTo(Status.O_WON));
	}
	
	//anti diag
	@Test
	public void refreshStatus_AntiDiag_x_won() {
		List<Step> steps = new ArrayList<>();
		steps.add(new Step(1L, 1, 1, 3));
		steps.add(new Step(1L, 2, 2, 3));
		steps.add(new Step(1L, 3, 2, 2));
		steps.add(new Step(1L, 4, 3, 3));
		steps.add(new Step(1L, 5, 3, 1));
		
		Mockito.when(stepDAO.getStepsByGame(Mockito.anyLong())).thenReturn(steps);
		Status status = gameService.refreshStatus(1L);
		
		assertThat(status, equalTo(Status.X_WON));
	}
	
	@Test
	public void refreshStatus_AntiDiag_o_won() {
		List<Step> steps = new ArrayList<>();
		steps.add(new Step(1L, 1, 2, 1));
		steps.add(new Step(1L, 2, 1, 3));
		steps.add(new Step(1L, 3, 1, 2));
		steps.add(new Step(1L, 4, 2, 2));
		steps.add(new Step(1L, 5, 3, 2));
		steps.add(new Step(1L, 6, 3, 1));
		
		Mockito.when(stepDAO.getStepsByGame(Mockito.anyLong())).thenReturn(steps);
		Status status = gameService.refreshStatus(1L);
		
		assertThat(status, equalTo(Status.O_WON));
	}
	
	@Test
	public void refreshStatus_Draw() {
		List<Step> steps = new ArrayList<>();
		steps.add(new Step(1L, 1, 2, 2));
		steps.add(new Step(1L, 2, 1, 1));
		steps.add(new Step(1L, 3, 1, 3));
		steps.add(new Step(1L, 4, 3, 1));
		steps.add(new Step(1L, 5, 2, 1));
		steps.add(new Step(1L, 6, 2, 3));
		steps.add(new Step(1L, 7, 1, 2));
		steps.add(new Step(1L, 8, 3, 2));
		
		Mockito.when(stepDAO.getStepsByGame(Mockito.anyLong())).thenReturn(steps);
		Status status = gameService.refreshStatus(1L);
		
		assertThat(status, equalTo(Status.DRAW));
	}
	
}
