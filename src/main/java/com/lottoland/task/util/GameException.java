package com.lottoland.task.util;

/**
 * Exception for games classes
 * 
 * @author Daniel Garcia
 */

public class GameException extends Exception {

	/**
	 * Serial version UID for GameException
	 */
	private static final long serialVersionUID = 3166922003926597982L;

	public GameException(String msg) {
        super(msg);
    }
}