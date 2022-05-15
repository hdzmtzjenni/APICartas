package game;
/*
 * This is an enumeration meant to represent the suits of Cards,it is contained within the Card class 
 * @author Jennifer Hernández, Gabriel Olvera 
 */
public enum Suits {
	HEART("heart"), // Heart Suit
	DIAMOND("diamond"), // Diamond Suit
	PIKES("pikes"), // Pike Suit
	CLUBS("clubs"); // Club Suit 
	
	private String suit; // Enum Suits has one private attribute that stores it's name in string. 
	
	private Suits(String suit) { // Private enum Contructor 
		this.suit=suit;
	}
	public String toString() { // ToString Override Function that returns the string value of enum. 
		return this.suit;
	}
}
