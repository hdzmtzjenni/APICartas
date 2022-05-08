package game;

import java.util.ArrayList;

/*
 * Esta clase define a cada jugador del juego
 * @author Jennifer Hernandez,Gabriel Olvera
 */
public abstract class Player {
	public ArrayList<Card> p_hand = new ArrayList<>();
	public String name;
	public int turn =0;
	public boolean handReady=false;
	
	public Player(){
		
	}
	public Player(String name) {
		setName(name);
	}
	
	public abstract void drawCard();
	public abstract void putCardInTrashPile();
	public abstract void passTurn();

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
	
	public abstract Boolean play(); // Juega de acuerdo al juego y devuelve true o false dependiendo si sigue jugando 
	


	
	
	
}
