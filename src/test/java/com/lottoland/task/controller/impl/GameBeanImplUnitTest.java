package com.lottoland.task.controller.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.lottoland.task.dao.GameDAO;
import com.lottoland.task.model.Game;
import com.lottoland.task.model.Round;

public class GameBeanImplUnitTest {
	
	GameBeanImpl gameBeanImpl = new GameBeanImpl();
	List<Game> gameList;
	
	@BeforeEach
	void loadGameListData() {
		
		gameBeanImpl = new GameBeanImpl();
		gameList = new ArrayList<Game>();
		List<Round> roundList = new ArrayList<Round>();
		
		// Create new round
		Round round = Round.builder()
				.id(1)
				.p1Choice(GameDAO.getGameValuesDef(0))
				.p2Choice(GameDAO.getGameValuesDef(1))
				.roundResultId(2)
				.roundResultName(GameDAO.getGameWinDef(2))
				.build();
		
		roundList.add(round);
		
		// Add new object of type Game
		Game game = Game.builder()
				.id(1)
				.user("danielg")
				.roundsStarted(1)
				.roundList(roundList)
				.build();
		gameList.add(game);	
		
		gameBeanImpl.setGamesStarted(1);
		
		gameBeanImpl.setGameList(gameList);
	}

	@DisplayName("Test newGame()")
	@Test
	void testnewGame() {
		gameBeanImpl.newGame();
		
		assertTrue(gameBeanImpl.getGameList().size() == 2);	
	}	
	
	@DisplayName("Test restartGame()")
	@Test
	void testRestartGame() {
		long idGame = gameBeanImpl.getGamesStarted();
		
		gameBeanImpl.restartGame(idGame);
		
		int result = gameBeanImpl.getGameList().stream()
		    .filter(game -> game.getId() == idGame)
		    .findFirst().get().getRoundList().size();
		
		assertTrue(result == 0);
		
	}
	
	@DisplayName("Test deleteGame()")
	@Test
	void testDeleteGame() {
		long idGame = gameBeanImpl.getGamesStarted();
		
		gameBeanImpl.deleteGame(idGame);
		
		int result = gameBeanImpl.getGameList().size();
		
		assertTrue(result == 0);
		
	}
	
	@DisplayName("Test playRound()")
	@Test
	void testPlayRound() {
		long idGame = gameBeanImpl.getGamesStarted();
		
		gameBeanImpl.playRound(idGame);
		
		int result = gameBeanImpl.getGameList().stream()
		    .filter(game -> game.getId() == idGame)
		    .findFirst().get().getRoundList().size();
			
		assertTrue(result == 2);
	}
	
	@DisplayName("Test newGameRound()")
	@Test
	void testNewGameRound() {
		long idGame = gameBeanImpl.getGamesStarted();
		
		long roundsStarted = gameBeanImpl.getGameList().stream().
			filter(game -> game.getId() == idGame).
			findFirst().get().getRoundsStarted();
		
		Round result = gameBeanImpl.newGameRound(idGame, roundsStarted);
		
		assertTrue((result != null) && (result.getId() == 2));
	}
}
