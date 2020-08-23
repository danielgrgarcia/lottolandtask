package com.lottoland.task.model;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

/**
 * Object with game data
 * 
 * @author Daniel Garcia
 */

@Getter
@Builder
public class Game {

	// Id of the game
	private long id;
	
	// Player username
	private String user;
	
	// List of rounds
	private List<Round> roundList;
}
