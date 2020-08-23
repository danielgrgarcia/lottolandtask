package com.lottoland.task.util;

/**
 * Util for games
 * 
 * @author Daniel Garcia
 */
public class GameUtil {
	
	/**
	 * Algorithm to calculate the winner
	 * @param valueP1 player 1 value
	 * @param valueP2 player 2 value
	 * @return
	 */
	public static int calculateWinner(int valueP1, int valueP2) {
		
		/*
		 * Taking the following values:
		 * 0 -> rock
		 * 1 -> paper
		 * 2 -> scissors
		 * If the values ​​P1 and P2 are equal the result is draw, otherwise the winner is calculated:
		 * Values of result:
		 * 0 -> Draw
		 * 1 -> P1 wins
		 * 2 -> P2 wins
		 */
		if (valueP1 != valueP2) {
			switch (valueP1) {
				case 0:
					switch (valueP2) {
						case 1: // rock vs. paper
							return 2; 
						case 2: // rock vs. scissors
							return 1;
					}
				case 1:
					switch (valueP2) {
						case 0: // paper vs. rock
							return 1; 
						case 2: // paper vs. scissors
							return 2;
					}
				case 2:
					switch (valueP2) {
						case 0: // scissors vs. rock
							return 2; 
						case 1: // scissors vs. paper
							return 1;
					}
			}
		}
		// If the values ​​P1 and P2 are equal the result is draw
		return 0;
	}
}