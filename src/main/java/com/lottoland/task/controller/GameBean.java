package com.lottoland.task.controller;

import com.lottoland.task.model.Round;

/**
 * Interface to communicate GameBean with Web
 * 
 * @author Daniel Garcia
 */
public interface GameBean {
	
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
	 * Create new round
	 * @param idGame the id of the game
	 * @return new round created
	 */
	public Round newGameRound(long idGame);

}
