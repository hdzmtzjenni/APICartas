package game;

import java.util.ArrayList;

public abstract class CardGame {
	public void start() {
		//revolver y repartir el juego
		PackOfCards pack = new PackOfCards();
		pack.startPack();
		pack.sortCards();
		
	}
	
	public abstract void winConditions();
	public abstract boolean endGame();
	public abstract Player getWinner();
	public abstract void addPlayer(String string, Player player4);
	public abstract void removePlayer(String string);

	
}
