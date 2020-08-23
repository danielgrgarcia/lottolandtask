package com.lottoland.task.controller.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameBeanImplUnitTest {
	
	GameBeanImpl gameBeanImpl = new GameBeanImpl();

	@DisplayName("Test newGame()")
	@Test
	void testnewGame() {
		gameBeanImpl.newGame("danielg");
		
		assertTrue(gameBeanImpl.getGameList().size() == 1);	
	}	
}
