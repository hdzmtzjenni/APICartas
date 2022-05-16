package game;

import java.util.ArrayList;

// Function Parent that represent a CardGame 

public abstract class CardGame {
	public abstract void start(); //Start Game 
	public abstract void reset(); // Reset Game
	public abstract Player nextPlayer(); // Next Player
	public abstract boolean endGame(); // End Game 
	public abstract ArrayList<Player> getWinner(); // Function that obtains winner 
	public abstract void addPlayer(String string, Player player); // Adds Players 
	public abstract void removePlayer(String string); // kicks Player according to name 
	public abstract void playGame(); // Plays game 

	
}
