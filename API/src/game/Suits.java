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
	
	private String nombre;
	
	private Suits(String nombre) {
		this.nombre=nombre;
	}
	public String toString() {
		return this.nombre;
	}
}
