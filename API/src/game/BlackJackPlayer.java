package game;

import java.util.ArrayList;

public abstract class BlackJackPlayer extends Player {
	
	public BlackJackPlayer(String name) {
		super (name);
	}

	public BlackJackPlayer(ArrayList<Card> p_hand, String name, int numPlayer) {
		super(p_hand, name, numPlayer);
	}
	
	public abstract void drawCard();
	public abstract void passTurn();

}
