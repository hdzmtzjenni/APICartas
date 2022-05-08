package game;


public abstract class CardGame {
	public abstract void start();
	public abstract void reset();
	public abstract Player nextPlayer();
	public abstract boolean endGame();
	public abstract Player getWinner();
	public abstract void addPlayer(String string, Player player4);
	public abstract void removePlayer(String string);

	
}
