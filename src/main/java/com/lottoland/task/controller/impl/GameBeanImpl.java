package com.lottoland.task.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lottoland.task.controller.GameBean;
import com.lottoland.task.model.Game;
import com.lottoland.task.model.Round;

import lombok.Getter;
import lombok.Setter;

/**
 * Communicate GameBean with Web
 * 
 * @author Daniel Garcia
 */
@Getter
@Setter
public class GameBeanImpl implements GameBean {

	private long gamesStarted = 0;
	protected List<Game> gameList = new ArrayList<Game>();
	
	private static final Logger logger = LogManager.getLogger(GameBeanImpl.class);
	
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
		gameList.stream()
	    .filter(game -> game.getId() == idGame)
	    .findFirst().get().getRoundList().clear();
		
		logger.debug("idGame " + idGame + " restarted");
	}

	/**
	 * Delete a game
	 * @param idGame the id of the game
	 */
	public void deleteGame(long idGame) {
		gameList.removeIf(game->game.getId() == idGame);
		
		logger.debug("idGame " + idGame + " removed");
	}
	
	/**
	 * Add new round to round list
	 * @param idGame the id of the game
	 */
	public void playRound(long idGame) {
		
		// Get the number of round started
		int roundsStarted = gameList.stream()
		    .filter(game -> game.getId() == idGame)
		    .findFirst().get().getRoundsStarted();
		
		// Create new round
		gameList.stream()
	    .filter(game -> game.getId() == idGame)
	    .findFirst().get().getRoundList().add(newGameRound(idGame, roundsStarted));
		
		logger.debug("Played 1 round in idGame " + idGame);
	}
}
