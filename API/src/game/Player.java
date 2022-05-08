package game;

import java.util.ArrayList;

/*
 * Esta clase define a cada jugador del juego
 * @author Jennifer Hernandez,Gabriel Olvera
 */
public class Player {
	public ArrayList<Card> p_hand = new ArrayList<>();
	public String name;
	public int turn =0;
	
	public Player(){
		
	}
	public Player(String name) {
		setName(name);
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

	public int getBlackJackvalue(){
		int sum =0;
		for (int i = 0; i < p_hand.size(); i++) {
			sum+= p_hand.get(i).number;
		}
		return sum;
	}

	
	
	
}
