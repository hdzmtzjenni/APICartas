package game;

public abstract class CardGame {
	public void start() {
		
	}
	
	public abstract void winConditions();
	public abstract boolean endGame();
	public abstract Player getWinner();
	
}
