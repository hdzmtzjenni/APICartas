package game;

/*
 * Esta clase define cada una de las cartas de la baraja
 * @author Jennifer Hernández,Gabriel Olvera
 */
public class Card {
//	Atributos
	private Suits suit;
	private int number;
	private int id;
	private String image;
	
	/*
	 * Constructor de la clase Card
	 * @param id es el identificador de cada carta
	 * @param suit es un valor tipo Suits que especifica en palo de la carta
	 * @param number es el número que identifica a la carta
	 * @param image es la dirección para la imagen de cada carta
	 */
	public Card(int id, Suits suit, int number,String image) {
		setSuit(suit);
		setNumber(number);
		setId(id);
		setImage(image);
	}

	/*
	 * Método que actualiza el valor del atributo suit
	 */
	public void setSuit(Suits suit) {
		this.suit = suit;
	}

	/*
	 * Método que actualiza el valor del atributo number
	 * @param number es el nuevo valor que tendra el atributo number
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/*
	 * Método que actualiza el valor del atributo id
	 * @param id es el nuevo valor que tendra el atributo id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/*
	 * Método que actualiza el valor del atributo image
	 * @param image es el nuevo valor que tendra el atributo image
	 */
	public void setImage(String image) {
		this.image=image;
	}
	
	/*
	 * Método que devuelve el palo de la carta
	 * @return el palo de la carta
	 */
	public Suits getSuit() {
		return suit;
	}

	/*
	 * Método que devuelve el numero de la carta
	 * @return el numero de la carta
	 */
	public int getNumber() {
		return number;
	}

	/*
	 * Método que devuelve el identificador de la carta
	 * @return el identifiador de la carta
	 */
	public int getId() {
		return id;
	}

	/*
	 * Método que devuelve la direccion de la imagen de la carta
	 * @return la direccion de la imagen de la carta
	 */
	public String getImage() {
		return image;
	}

	@Override
	public String toString() {
		return id + ",N" + number + ","+suit;
	}
	
	
	
	
	
}
