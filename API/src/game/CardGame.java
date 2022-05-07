package game;

public abstract class CardGame {
	public void start() {
		//revolver y repartir el juego
		PackOfCards pack = new PackOfCards();
	}
	
	public abstract void winConditions();
	public abstract boolean endGame();
	public abstract Player getWinner();
	
}
