package game;

public class Card {
	private Suits suit;
	private int number;
	private int id;
	//private String image;
	
	public Card(int id, Suits suit, int number) {
		setSuit(suit);
		setNumber(number);
		setId(id);
//		setImage(image);
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
	
//	public void setImage(String image) {
//		this.image=image;
//	}
	
	
	
	
	
}
