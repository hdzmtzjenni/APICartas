package game;

/*
 * Esta clase define cada una de las cartas de la baraja
 * @author Jennifer Hernandez,Gabriel Olvera
 */
public class Card implements Comparable<Card>{
//	Atributos
	protected Suits suit;
	protected int value;
	protected int id;
	protected String image;
	protected  String  color;
	
	/*
	 * Constructor de la clase Card
	 * @param id es el identificador de cada carta
	 * @param suit es un valor tipo Suits que especifica en palo de la carta
	 * @param number es el numero que identifica a la carta
	 * @param image es la dirección para la imagen de cada carta
	 */
	public Card(int id, Suits suit, int value,String image,String color) {
		setSuit(suit);
		setValue(value);
		setId(id);
		setImage(image);
		setColor(color);
	}


    /*
	 * Metodo que actualiza el valor del atributo suit
	 */
	public void setSuit(Suits suit) {
		this.suit = suit;
	}

	/*
	 * Metodo que actualiza el valor del atributo number
	 * @param number es el nuevo valor que tendra el atributo number
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/*
	 * Metodo que actualiza el valor del atributo id
	 * @param id es el nuevo valor que tendra el atributo id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/*
	 * Metodo que actualiza el valor del atributo image
	 * @param image es el nuevo valor que tendra el atributo image
	 */
	public void setImage(String image) {
		this.image=image;
	}
	
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	/*
	 * Metodo que devuelve el palo de la carta
	 * @return el palo de la carta
	 */
	public Suits getSuit() {
		return suit;
	}

	/*
	 * Metodo que devuelve el numero de la carta
	 * @return el numero de la carta
	 */
	public int getValue() {
		return value;
	}

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
	 * Metodo que devuelve el identificador de la carta
	 * @return el identifiador de la carta
	 */
	public int getId() {
		return id;
	}

	/*
	 * Metodo que devuelve la direccion de la imagen de la carta
	 * @return la direccion de la imagen de la carta
	 */
	public String getImage() {
		return image;
	}

	@Override
	public String toString() {
		return  getValueString() + "|"+suit + "|"+color;
	}

	@Override
	public int compareTo(Card o) {
		if(this.value == o.value) return 0;
		if(this.value< o.value) return -1;
		return 1;
	}
	
	
	
	
	
}
