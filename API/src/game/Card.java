package game;

/**
 * This Class Defines Primary Card. Fundamental of every single class. 
 * @author Jennifer Hernandez,Gabriel Olvera
 */
public class Card implements Comparable<Card>{ // Use a comparable implementation to be able to use generic Collections methos such as sort 
//	Atributos
	protected Suits suit;
	protected int value;
	protected  String  color;
	
	 /** 
	  * Constructor of Card Class
	  * @param suit an instance of enum Suits that represents suit of card 
	  * @param value is number of each Card 
	  * @param color of each Card
	  */
	public Card( Suits suit, int value,String color) { // Public Constructor 
		setSuit(suit);
		setValue(value);
		setColor(color);
	}

	/**
	 * Set Suit of Card 
	 * @param suit
	 */
	public void setSuit(Suits suit) {
		this.suit = suit;
	}

	/**
	 * 
	 * @param color
	 */
	private void setColor(String color) {
		this.color = color;
	}

	/** 
	 * Set Number of Card 
	 * @param value new value of Card 
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/** 
	 * Return Color of Card
	 * @return color
	 */
	public String getColor() { 
		return color;
	}

	/**
	 * Return Suit of Card using Suits enum 
	 * @return Suit 
	 */
	public Suits getSuit() {
		return suit;
	}

	/**
	 * Method that return number of Card 
	 * @return card value 
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * Each Card Has its own value to string
	 * @return String value
	 */
	public String getValueString() {
		switch (value) {
		case 1: return "As";
		case 2: return "2";
		case 3: return "3";
		case 4: return "4";
		case 5: return "5";
		case 6: return "6";
		case 7: return "7";
		case 8: return "8";
		case 9: return "9";
		case 10: return "10";
		case 11: return "J";
		case 12: return "Q";
		case 13: return "K";
		default: return "??";
		}
	}
	
	/** 
	 *  Override Of String that prints suit and color 
	 * @return String
	 */
	@Override 
	public String toString() {
		return  getValueString() + "|"+suit + "|"+color;
	}

	/**
	 * Override of Compare to , this adds a comparable implementation and also allows to implement generic methods such as sort 
	 */
	@Override 
	public int compareTo(Card o) {
		if(this.value == o.value) return 0;
		if(this.value< o.value) return -1;
		return 1;
	}
}
