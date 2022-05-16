package game;

import java.util.ArrayList;

/** 
 * Class that represents Player of all the API, it contains abstract methods that are implemented in every single Game. 
 * @author Jennifer Hernandez,Gabriel Olvera
 */
public abstract class Player {
	protected  ArrayList<Card> p_hand = new ArrayList<>(); // Your Hand of Cards
	protected String name; // Name
	protected int turn =0; // Turn is used as a control in a lot of turn management functions 
	protected boolean handReady=false; // Boolean to determine wether your hand is ready 
	protected Card maxPlayableCard; // Card that is the highest according to game, used to tie brake or check winners 

	/**
	 * Public Player Constructor 
	 * @param name
	 */
	public Player() { 
		
	}
	
	/**
	 * Add a card from the Pack of cards and erase it from it 
	 */
	public void drawCard(){ 
		this.p_hand.add(BlackJackGame.pack.getPack().get(0));
		BlackJackGame.pack.getPack().remove(0);
	}
	
	/**
	 * Tentative function for games that use a Trash Pile 
	 */
	public  void putCardInTrashPile(){ 

	}

	/**
	 * Function that enables hand ready and also passes turn 
	 */
	public  void passTurn(){ 
		this.handReady=true;
		this.turn++;
	}

	/**
	 * Function used to determine the value of the cards you have 
	 * @return p_hand your hand of cards 
	 */
	public abstract int sumOfHand(); 
	
	/**
	 * Methor that return the hand of cards
	 * @return p_hand
	 */
	public ArrayList<Card> getP_hand() { 
		return p_hand;
	}

	/**
	 * Set your hand of cards
	 * @param p_hand
	 */
	public void setP_hand(ArrayList<Card> p_hand) { 
		this.p_hand = p_hand;
	}

	/**
	 * returns your name
	 * @return name
	 */
	public String getName() { 
		return name;
	}

	/**
	 * sets your name
	 * @param name
	 */
	public void setName(String name) { 
		this.name = name;
	}

	/**
	 * gets MaxPlayableCard
	 * @return Card
	 */
	public Card getMaxPlayableCard() { 
		return maxPlayableCard;
	}
	
	/**
	 * method that return the number of turn of the Player
	 * @return turn 
	 */
	public int getTurn() {
		return turn;
	}

	/**
	 * Set the number of turns
	 * @param turn
	 */
	public void setTurn(int turn) {
		this.turn = turn;
	}

	/**
	 * Method that return if the player end your turn
	 * @return handReady
	 */
	public boolean isHandReady() {
		return handReady;
	}

	/**
	 * Set handReady
	 * @param handReady
	 */
	public void setHandReady(boolean handReady) {
		this.handReady = handReady;
	}

	/**
	 * Set MaxPlayableCard
	 * @param maxPlayableCard
	 */
	public void setMaxPlayableCard(Card maxPlayableCard) {
		this.maxPlayableCard = maxPlayableCard;
	}

	/**
	 * Override To Print Name
	 */
	@Override
	public String toString(){ 
		return this.name;
	}
	
	/**
	 * Each Play is different from game to game
	 */
	public abstract void play(); 

	/**
	 * Function to determine wether all your cards are same suit 
	 * @return boolean
	 */
	public boolean sameSuit() { 
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
