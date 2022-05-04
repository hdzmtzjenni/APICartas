package game;

import java.util.ArrayList;

public class Player {
	public ArrayList<Card> p_hand;
	public String name;
	public int numPlayer;
	
	public Player(ArrayList<Card> p_hand, String name, int numPlayer) {
		super();
		this.p_hand = p_hand;
		this.name = name;
		this.numPlayer = numPlayer;
	}

	public ArrayList<Card> getP_hand() {
		return p_hand;
	}

	public void setP_hand(ArrayList<Card> p_hand) {
		this.p_hand = p_hand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumPlayer() {
		return numPlayer;
	}

	public void setNumPlayer(int numPlayer) {
		this.numPlayer = numPlayer;
	}
	
	
	
	
}
