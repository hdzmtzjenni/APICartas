package game;

import java.util.ArrayList;

/*
 * Class that represents Player of all the API, it contains abstract methods that are implemented in every single Game. 
 * @author Jennifer Hernandez,Gabriel Olvera
 */
public abstract class Player {
	public  ArrayList<Card> p_hand = new ArrayList<>(); // Your Hand of Cards
	public String name; // Name
	public int turn =0; // Turn is used as a control in a lot of turn management functions 
	public boolean handReady=false; // Boolean to determine wether your hand is ready 
	public Card maxPlayableCard; // Card that is the highest according to game, used to tie brake or check winners 

	
	public Player(){ // Public Constructor
		
	}
	public Player(String name) { // Name Constructor 
		setName(name);
	}
	
	public void drawCard(){ // Add a card from the Pack of cards and erase it from it 
		this.p_hand.add(BlackJackGame.pack.getPack().get(0));
		BlackJackGame.pack.getPack().remove(0);
	}
	public  void putCardInTrashPile(){ // Tentative function for games that use a Trash Pile 

	}
	public  void passTurn(){ // Function that enables hand ready and also passes turn. 
		this.handReady=true;
		this.turn++;
	}

	public abstract int sumOfHand(); // Function used to determine the value of the cards you have 
	
	public ArrayList<Card> getP_hand() { // returns your hand of cards 
		return p_hand;
	}

	public void setP_hand(ArrayList<Card> p_hand) { // Set your hand of cards
		this.p_hand = p_hand;
	}

	public String getName() { // returns your name
		return name;
	}

	public void setName(String name) { // sets your name
		this.name = name;
	}
	public Card getMaxPlayableCard() { // gets MaxPlayableCard
		return maxPlayableCard;
	}
	
	@Override
	public String toString(){ // Override To Print Name
		return this.name;
	}
	
	public abstract void play(); // Each Play is different from game to game, 
	

	public boolean sameSuit() { // Function to determine wether all your cards are same suit 
		int flag = 0;
		Suits suit = p_hand.get(0).getSuit();
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
