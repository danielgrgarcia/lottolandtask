package com.lottoland.task.controller.impl;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

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

@ManagedBean (name="gameBean")
@ViewScoped
@Getter
@Setter
public class GameBeanImpl implements GameBean {

	private long gamesStarted = 0;
	private long totalRounds = 0;
	private long totalP1Wins = 0;
	private long totalP2Wins = 0;
	private long totalDraws = 0;
	protected List<Game> gameList = new ArrayList<Game>();
	private String user = "";
	private static final Logger logger = LogManager.getLogger(GameBeanImpl.class);
	
	/**
	 * Start new game
	 */
	public void newGame() {
		List<Round> roundList = new ArrayList<Round>();
		
		// The first round is number 1
		int roundsStarted = 1;
		Round gameRound = newGameRound(gamesStarted, roundsStarted);
		
		// Add to roundList a new round
		roundList.add(gameRound);
		setTotalCounters(gameRound.getRoundResultId());
		
		// Add new object of type Game
		Game game = Game.builder()
				.id(gamesStarted)
				.user(user)
				.roundsStarted(roundsStarted)
				.roundList(roundList)
				.build();
		gameList.add(game);
		
		logger.debug("New idGame " + gamesStarted);
		
		// The user variable is reset to appears empty in the text box
		user = "";
		
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
		Round gameRound = newGameRound(idGame, roundsStarted);
		
		gameList.stream()
	    .filter(game -> game.getId() == idGame)
	    .findFirst().get().getRoundList().add(gameRound);
		setTotalCounters(gameRound.getRoundResultId());
		
		logger.debug("Played 1 round in idGame " + idGame);
	}
	
	/**
	 * Get username of the game
	 * @param idGame the id of the game
	 * @return the username of the game
	 */
	public String getUserGame(long idGame) {
		return gameList.stream()
			.filter(game -> game.getId() == idGame)
			.findFirst().get().getUser();
	}
	
	/**
	 * Get the results of the rounds that belongs to a game
	 * @param idGame the id of the game
	 * @return List of rounds
	 */
	public List<Round> getRoundsResults(long idGame) {

		return gameList.stream()
				.filter(game -> game.getId() == idGame)
				.findFirst().get().getRoundList();
	}
	
	/**
	 * Get number of actual rounds
	 * @param idGame the id of the game
	 * @return the number of actual rounds
	 */
	public int getActualRoundsNum(long idGame) {

		return gameList.stream()
				.filter(game -> game.getId() == idGame)
			    .findFirst().get().getRoundList().size();
	}
	
	/**
	 * Set counters of rounds, P1 wins, P2 wins and draws
	 */
	public void setTotalCounters(int resultId) {

		totalRounds++;
		switch (resultId) {
			case 0:  
				totalDraws++;
			break;
			case 1:  
				totalP1Wins++;
			break;
			case 2:  
				totalP2Wins++;
			break;
		}
	}
}
