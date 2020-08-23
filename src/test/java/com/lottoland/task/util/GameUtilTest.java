package com.lottoland.task.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("GameUtil Test")
class GameUtilTest {

	@DisplayName("Test calculateWinner Rock vs. Rock")
	@Test
	void testCalculateWinner00() {
		
		int result = GameUtil.calculateWinner(0, 0);
		
		assertEquals(result, 0);
	}
	
	@DisplayName("Test calculateWinner Rock vs. Paper")
	@Test
	void testCalculateWinner01() {
		
		int result = GameUtil.calculateWinner(0, 1);
		
		assertEquals(result, 2);
	}
	
	@DisplayName("Test calculateWinner Rock vs. Scissors")
	@Test
	void testCalculateWinner02() {
		
		int result = GameUtil.calculateWinner(0, 2);
		
		assertEquals(result, 1);
	}
	
	@DisplayName("Test calculateWinner Paper vs. Paper")
	@Test
	void testCalculateWinner11() {
		
		int result = GameUtil.calculateWinner(1, 1);
		
		assertEquals(result, 0);
	}
	
	@DisplayName("Test calculateWinner Paper vs. Rock")
	@Test
	void testCalculateWinner10() {
		
		int result = GameUtil.calculateWinner(1, 0);
		
		assertEquals(result, 1);
	}
	
	@DisplayName("Test calculateWinner Paper vs. Scissors")
	@Test
	void testCalculateWinner12() {
		
		int result = GameUtil.calculateWinner(1, 2);
		
		assertEquals(result, 2);
	}
	
	@DisplayName("Test calculateWinner Scissors vs. Scissors")
	@Test
	void testCalculateWinner22() {
		
		int result = GameUtil.calculateWinner(2, 2);
		
		assertEquals(result, 0);
	}
	
	@DisplayName("Test calculateWinner Scissors vs. Rock")
	@Test
	void testCalculateWinner20() {
		
		int result = GameUtil.calculateWinner(2, 0);
		
		assertEquals(result, 2);
	}
	
	@DisplayName("Test calculateWinner Scissors vs. Paper")
	@Test
	void testCalculateWinner21() {
		
		int result = GameUtil.calculateWinner(2, 1);
		
		assertEquals(result, 1);
	}

}
