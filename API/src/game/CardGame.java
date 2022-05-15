package game;

import java.util.ArrayList;

import game.exception.NoPlayersException;
import game.exception.NullException;

public abstract class CardGame {
	public abstract void start() throws NoPlayersException;
	public abstract void reset();
	public abstract Player nextPlayer();
	public abstract boolean endGame();
	public abstract ArrayList<Player> getWinner();
	public abstract void addPlayer(String string, Player player);
	public abstract void removePlayer(String string);
	public abstract void playGame();

	
}
