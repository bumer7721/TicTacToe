package com.pragmaticplay.tictactoe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.pragmaticplay.tictactoe.db.dao.GameDAO;
import com.pragmaticplay.tictactoe.db.dao.StepDAO;
import com.pragmaticplay.tictactoe.db.entity.Step;
import com.pragmaticplay.tictactoe.db.enums.Status;
import com.pragmaticplay.tictactoe.service.GameService;

@Service
public class GameServiceImpl implements GameService {
	
	@Autowired
	private StepDAO stepDAO;
	
	@Autowired
	private GameDAO gameDAO;
	
	@Override
	public Status refreshStatus(Long gameId) {
		List<Step> steps = stepDAO.getStepsByGame(gameId); 
		Board board = new Board(steps);
		Status currentStatusGame = board.getStatus();
		gameDAO.udateStatus(gameId, currentStatusGame);
		return currentStatusGame;
	}
	
	private class Board {
		private final static int BOARD_SIZE = 3;
		private final static int X = 1;
		private final static int O = 2;
		private final static int BLANK = 0;
		
		private int[][] board = new int[BOARD_SIZE][BOARD_SIZE];
		private Status status = Status.IN_PROGRESS;
		private int moveCount;
		
		public Board(List<Step> steps) {
			if (!CollectionUtils.isEmpty(steps)) {
				moveCount = steps.size();
				for (Step step : steps) {
					board[step.getX()-1][step.getY()-1] = stepToPlayer(step);
				}
			} 
		}
		
		public boolean isBlank() {
			for (int[] row : board) {
				for (int cell : row) {
					if (cell != BLANK) {
						return false;
					}
				}
			}
			return true;
		}
		
		public Status getStatus() {
			
			if (isBlank()) {
				return status;
			}
			
			//rows;
			for (int[] row : board) {
				int countX = 0;
				int countO = 0;
				for (int cell : row) {
					if (cell == X) {
						countX+=1;
					} else if (cell == O) {
						countO+=1;
					}
				}
				if (countX == 3) {
					return Status.X_WON;
				} else if (countO == 3) {
					return Status.O_WON;
				}
			}
			
			//cols;
			for (int i=0; i<BOARD_SIZE; i++) {
				int countX = 0;
				int countO = 0;
				for (int j=0; j<BOARD_SIZE; j++) {
					int cell = board[j][i];
					if (cell == X) {
						countX+=1;
					} else if (cell == O) {
						countO+=1;
					}
				}
				if (countX == 3) {
					return Status.X_WON;
				} else if (countO == 3) {
					return Status.O_WON;
				}
			}
			
			//diag
			int countX = 0;
			int countO = 0;
			for (int i=0; i<BOARD_SIZE; i++) {
				int cell = board[i][i];
				if (cell == X) {
					countX+=1;
				} else if (cell == O) {
					countO+=1;
				}
			}
			if (countX == 3) {
				return Status.X_WON;
			} else if (countO == 3) {
				return Status.O_WON;
			}
			
			//anti diag
			countX = 0;
			countO = 0;
			for (int i=0; i<BOARD_SIZE; i++) {
				int cell = board[i][BOARD_SIZE-1-i];
				if (cell == X) {
					countX+=1;
				} else if (cell == O) {
					countO+=1;
				}
			}
			if (countX == 3) {
				return Status.X_WON;
			} else if (countO == 3) {
				return Status.O_WON;
			}
			
			//draw
			if(moveCount == (Math.pow(BOARD_SIZE, 2) - 1)){
				return Status.DRAW;
	        }
			
			return status;
		}
		
		private int stepToPlayer(Step step) {
			int res = 0;
			if (step.getNumberOfStep()%2==0) {
				res = O;
			} else {
				res = X;
			}
			return res;
		}
	}

}
