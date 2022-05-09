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

	public int sumOfHand(){
		int value=0;
		boolean as= false;
		
		for ( int i = 0; i < p_hand.size(); i++ ) {
			int cardValue = p_hand.get(i).number;
			if (cardValue > 10) {
				cardValue = 10;
			}
			if (cardValue == 1) {
				as = true;
			}
			value +=cardValue;
		}

		/* El as vale 1 al principio, pero si al cambiar su valor por 11 el resultado es igual a 21 o menor se cambia*/
		if ( as == true && value + 10 <= 21 )
			value = value + 10;
		return value;
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
	
	@Override
	public String toString(){
		return this.name;
	}
	
	public abstract Boolean play(); // Juega de acuerdo al juego y devuelve true o false dependiendo si sigue jugando 
	


	
	
	
}
