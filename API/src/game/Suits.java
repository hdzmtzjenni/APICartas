package game;
/*
 * Esta es una enumeración que contiene los palos de la baraja
 * @author Jennifer Hernández,Gabriel Olvera
 */
public enum Suits {
	HEART("heart"),
	DIAMOND("diamond"),
	PIKES("pikes"),
	CLUBS("clubs");
	
	private String nombre;
	
	private Suits(String nombre) {
		this.nombre=nombre;
	}
	public String toString() {
		return this.nombre;
	}
}
