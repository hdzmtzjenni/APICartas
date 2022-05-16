package game;

import java.util.ArrayList;

/**
 * Function Parent that represent a CardGame
 * @author Jennifer Hernandez,Gabriel Olvera
 */
public abstract class CardGame {
	/**
	 * Start Game
	 */
	public abstract void start();  
	
	/**
	 * Reset Game
	 */
	public abstract void reset(); 

	/**
	 * Next Player
	 * @return Player
	 */
	public abstract Player nextPlayer(); 

	/**
	 * End Game
	 * @return boolean
	 */
	public abstract boolean endGame(); 

	/**
	 * Function that obtains winner 
	 * @return ArrayList<Player> winners
	 */
	public abstract ArrayList<Player> getWinner(); 

	/**
	 * Adds Players 
	 * @param string
	 * @param player
	 */
	public abstract void addPlayer(String string, Player player); 

	/**
	 * kicks Player according to name 
	 * @param string
	 */
	public abstract void removePlayer(String string); 

	/**
	 * Plays game 
	 */
	public abstract void playGame(); 

	
}
