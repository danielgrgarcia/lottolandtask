package com.lottoland.task.controller.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.lottoland.task.controller.GameBean;
import com.lottoland.task.dao.GameDAO;
import com.lottoland.task.model.Game;
import com.lottoland.task.model.Round;

@DisplayName("GameBeanImpl Mockito Test")
class GameBeanImplMockitoTest {
	
	@InjectMocks
	private GameBeanImpl gameBeanImpl = Mockito.mock(GameBeanImpl.class);

	@Mock
	private GameBean gameBean = Mockito.mock(GameBean.class);
	
	List<Game> gameList = new ArrayList<Game>();
	
	@BeforeEach
	void loadGameListData() {
		
		List<Round> roundList = new ArrayList<Round>();
		
		// Create new round
		Round round = Round.builder()
				.id(1)
				.p1Choice(GameDAO.getGameValuesDef(0))
				.p2Choice(GameDAO.getGameValuesDef(1))
				.roundResult(GameDAO.getGameWinDef(2))
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
	}
	
	@DisplayName("Test playRound()")
	@Test
	void testPlayRound() {
		
		long idGame = 1;
		
		long roundsStarted = 1;
		
		Round round = Round.builder()
			.id(roundsStarted)
			.p1Choice(GameDAO.getGameValuesDef(0))
			.p2Choice(GameDAO.getGameValuesDef(1))
			.roundResult(GameDAO.getGameWinDef(2))
			.build();
		
		Mockito.when(gameBean.newGameRound(idGame, roundsStarted)).thenReturn(round);
		
		gameBeanImpl.playRound(idGame);
		
		int result = gameList.stream()
		    .filter(game -> game.getId() == idGame)
		    .findFirst().get().getRoundList().size();
			
		assertTrue(result == 1);
	}
	
}