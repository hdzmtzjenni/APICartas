
public class Card {
	private Suits suit;
	private int number;
	private int id;
	
	public Card(Suits suit, int number, int id) {
		setSuit(suit);
		setNumber(number);
		setId(id);
	}

	public void setSuit(Suits suit) {
		this.suit = suit;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	
}
