package com.lottoland.task.dao;

import java.util.HashMap;
import java.util.Map;

/**
 * DAO for game data
 * 
 * @author Daniel Garcia
 */
public class GameDAO {

	/**
	 * Get definition for game player value
	 * @param valueP the game player value
	 * @return the game player definition
	 */
	public static String getGameValuesDef(int valueP) {
		// Mock with game player data
		Map<Integer, String> valuesMap = new HashMap<>();
		valuesMap.put(0, "rock");
		valuesMap.put(1, "paper");
		valuesMap.put(2, "scissors");
		
		return valuesMap.get(valueP);
	}
	
	/**
	 * Get definition for game winner value
	 * @param valueR the game winner value
	 * @return the game winner definition
	 */
	public static String getGameWinDef(int valueR) {
		// Mock with game winner data
		Map<Integer, String> valuesWinMap = new HashMap<>();
		valuesWinMap.put(0, "Draw");
		valuesWinMap.put(1, "Player 1");
		valuesWinMap.put(2, "Player 2");
		
		return valuesWinMap.get(valueR);
	}
	
}
