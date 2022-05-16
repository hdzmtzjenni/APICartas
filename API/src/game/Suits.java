package game;
/** 
 * This is an enumeration meant to represent the suits of Cards,it is contained within the Card class 
 * @author Jennifer Hern�ndez, Gabriel Olvera 
 */
public enum Suits {
	HEART("heart"), // Heart Suit
	DIAMOND("diamond"), // Diamond Suit
	PIKES("pikes"), // Pike Suit
	CLUBS("clubs"); // Club Suit 
	
	private String suit; //Enum Suits has one private attribute that stores it's name in string. 
	
	/**
	 * Private enum Contructor 
	 * @param suit
	 */
	private Suits(String suit) { 
		this.suit=suit;
	}

	/**
	 * ToString Override Function that returns the string value of enum. 
	 */
	@Override
	public String toString() { 
		return this.suit;
	}
}
