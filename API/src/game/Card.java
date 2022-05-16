package game;

/*
 * This Class Defines Primary Card. Fundamental of every single class. 
 * @author Jennifer Hernandez,Gabriel Olvera
 */
public class Card implements Comparable<Card>{ // Use a comparable implementation to be able to use generic Collections methos such as sort 
//	Atributos
	protected Suits suit;
	protected int value;
	protected int id;
	protected  String  color;
	
	/*
	 * Constructor of Card Class
	 * @param id of each card
	 * @param suit an instance of enum Suits that represents suit of card 
	 * @param number is number of each Card 
	 */
	public Card(int id, Suits suit, int value,String image,String color) { // Public Constructor 
		setSuit(suit);
		setValue(value);
		setId(id);
		setColor(color);
	}


    /*
	 * Set Suit of Card 
	 */
	public void setSuit(Suits suit) {
		this.suit = suit;
	}

	/*
	 * Set Number of Card 
	 * @param number new value of Card 
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/*
	 * Set Id Of each Card 
	 * @param id new id 
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	public String getColor() { // Returns Color of Card 
		return color;
	}

	public void setColor(String color) { // Set Color of Card 
		this.color = color;
	}

	/*
	 * Return Suit of Card using Suits enum 
	 * @return Suit 
	 */
	public Suits getSuit() {
		return suit;
	}

	/*
	 * Method that return number of Card 
	 * @return card value 
	 */
	public int getValue() {
		return value;
	}
	
	// Each Card Has its own value to string 

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
	/*
	 * Return Id
	 * @return Id 
	 */
	public int getId() {
		return id;
	}

	@Override // Override Of String that prints suit and color 
	public String toString() {
		return  getValueString() + "|"+suit + "|"+color;
	}

	@Override // Override of Compare to , this adds a comparable implementation and also allows to implement generic methods such as sort 
	public int compareTo(Card o) {
		if(this.value == o.value) return 0;
		if(this.value< o.value) return -1;
		return 1;
	}
	
	
	
	
	
}
