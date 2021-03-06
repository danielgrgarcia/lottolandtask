package com.lottoland.task.controller;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lottoland.task.controller.impl.GameBeanImpl;
import com.lottoland.task.dao.GameDAO;
import com.lottoland.task.model.Round;
import com.lottoland.task.util.GameException;
import com.lottoland.task.util.GameUtil;

/**
 * Interface to communicate GameBean with Web
 * 
 * @author Daniel Garcia
 */
public interface GameBean {
	
	static final Logger logger = LogManager.getLogger(GameBeanImpl.class);
	
	/**
	 * Start new game
	 */
	public void newGame();
	
	/**
	 * Restart the game
	 * @param idGame the id of the game
	 */
	public void restartGame(long idGame);
	
	/**
	 * Delete a game
	 * @param idGame the id of the game
	 */
	public void deleteGame(long idGame);
	
	/**
	 * Add new round to round list
	 * @param idGame the id of the game
	 */
	public void playRound(long idGame);
	
	/**
	 * Create new round
	 * @param idGame the id of the game
	 * @param roundsStarted the number of rounds started
	 * @return new round created
	 */
	public default Round newGameRound(long idGame, long roundsStarted) {
		
		final int DEFAULT_VALUE_PLAYER2 = 0;
		
		// Initialize values of players
		Random r = new Random();
		int valueP1 = r.ints(1, 0, 3).findFirst().getAsInt();
		int valueP2 = DEFAULT_VALUE_PLAYER2;
		
		int roundResult = 0;
		
		try {
			// Calculate the winner of the game		
			roundResult = GameUtil.calculateWinner(valueP1, valueP2);
			
			// Error if the result is not P1, P2 or draw
			if(roundResult > 2){
	            throw new GameException("Error calculating winner of the game");
	        }
		}
		catch(GameException ex)
		{
			logger.error("Error creating new Round " + roundsStarted + " in gameId " + idGame);
		}
		
		// Create new round
		Round round = Round.builder()
				.id(roundsStarted + 1)
				.p1Choice(GameDAO.getGameValuesDef(valueP1))
				.p2Choice(GameDAO.getGameValuesDef(valueP2))
				.roundResultId(roundResult)
				.roundResultName(GameDAO.getGameWinDef(roundResult))
				.build();
		
		return round;
	}

}
