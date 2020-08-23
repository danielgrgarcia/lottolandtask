package com.lottoland.task.model;

import lombok.Builder;
import lombok.Getter;

/**
 * Object with round data
 * 
 * @author Daniel Garcia
 */

@Getter
@Builder
public class Round {

	// Id of the round
	private long id;
	
	// Player1 choice
	private String p1Choice;
	
	// Player2 choice
	private String p2Choice;
	
	//Round result
	private String roundResult;
}
