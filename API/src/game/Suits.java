package game;
/*
 * Esta es una enumeracion que contiene los palos de la baraja
 * @author Jennifer Hernandez,Gabriel Olvera
 */
public enum Suits {
	HEART("heart"),
	DIAMOND("diamond"),
	PIKES("pikes"),
	CLUBS("clubs");
	
	private String suit;
	
	private Suits(String suit) {
		this.suit=suit;
	}
	public String toString() {
		return this.suit;
	}
}
