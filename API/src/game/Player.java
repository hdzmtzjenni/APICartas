package game;

import java.util.ArrayList;

/*
 * Esta clase define a cada jugador del juego
 * @author Jennifer Hernandez,Gabriel Olvera
 */
public abstract class Player {
	public  ArrayList<Card> p_hand = new ArrayList<>();
	public String name;
	public int turn =0;
	public boolean handReady=false;
	
	public Player(){
		
	}
	public Player(String name) {
		setName(name);
	}
	
	public void drawCard(){
		this.p_hand.add(BlackJackGame.pack.getPack().get(0));
		BlackJackGame.pack.getPack().remove(0);
	}
	public  void putCardInTrashPile(){

	}
	public  void passTurn(){
		this.handReady=true;
		this.turn++;
	}

	public abstract int sumOfHand();
	
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
	
	@Override
	public String toString(){
		return this.name;
	}
	
	public abstract Boolean play(); // Juega de acuerdo al juego y devuelve true o false dependiendo si sigue jugando 
	

	public boolean sameSuit() {
		int flag = 0;
		Suits suit = p_hand.get(turn).getSuit();
		for (Card c: p_hand) {
			if(c.getSuit()== suit) flag++;
		}
		if (flag == p_hand.size()) {
			 return true;
					 
		} else {
			return false;
		}
	}
	
	
	
}
