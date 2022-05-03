
public enum Suits {
	CORAZON("Corazon"),
	DIAMANTE("Diamante"),
	ESPADA("Espada"),
	TREBOL("Trebol");
	
	private String nombre;
	
	private Suits(String nombre) {
		this.nombre=nombre;
	}
	public String toString() {
		return this.nombre;
	}
}
