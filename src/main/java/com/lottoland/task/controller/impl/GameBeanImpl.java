package com.lottoland.task.controller.impl;

import java.util.ArrayList;
import java.util.List;

import com.lottoland.task.controller.GameBean;
import com.lottoland.task.model.Game;
import com.lottoland.task.model.Round;

import lombok.Getter;

/**
 * Communicate GameBean with Web
 * 
 * @author Daniel Garcia
 */
@Getter
public class GameBeanImpl implements GameBean {

	private long gamesStarted = 0;
	protected List<Game> gameList = new ArrayList<Game>();
	
	/**
	 * Start new game
	 */
	public void newGame(String user) {
		List<Round> roundList = new ArrayList<Round>();
		
		// The first round is number 1
		int roundsStarted = 1;
		
		// Add to roundList a new round
		roundList.add(newGameRound(gamesStarted, roundsStarted));
		
		// Add new object of type Game
		Game game = Game.builder()
				.id(gamesStarted)
				.user(user)
				.roundsStarted(roundsStarted)
				.roundList(roundList)
				.build();
		gameList.add(game);
		
		logger.debug("New idGame " + gamesStarted);
		
		// Increment the counter of games started
		gamesStarted++;
		
	}

	/**
	 * Restart the game
	 * @param idGame the id of the game
	 */
	public void restartGame(long idGame) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Delete a game
	 * @param idGame the id of the game
	 */
	public void deleteGame(long idGame) {
		// TODO Auto-generated method stub
		
	}

}
