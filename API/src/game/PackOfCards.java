package game;
import java.util.ArrayList;

/** 
 * Pack Of Cards is a class that is used to start the game and to keep control that the cards are never repeated 
 * @author Jennifer Hernandez,Gabriel Olvera
 */
public class PackOfCards {
// Atributos
	public ArrayList<Card> pack; // Pack of cards 
	
	/** 
	 * constructor of class
	 * Initializes de pack 
	 */
	public PackOfCards() {
		pack = new ArrayList<>();
	}

	/** 
	 * Method that returns the pack of Class
	 * @returns the pack 
	 */
	public ArrayList<Card> getPack() {
		return pack;
	}

	
	/** 
	 * Method that assing the 52 cards to the pack 
	 */
	public void startPack() {
		ArrayList<Suits> suits = new ArrayList<>();
		suits.add(Suits.HEART); suits.add(Suits.DIAMOND);
		suits.add(Suits.PIKES); suits.add(Suits.CLUBS);
		
		for(int i =1; i<5; i++) {
			for(int j=1; j<14; j++) {
				if (i>2) {
					Card e = new Card(suits.get(i-1),j,"Black");
					pack.add(e);
				}
				else{
					Card e = new Card(suits.get(i-1),j,"Red");
					pack.add(e);
				}
				
			}
		}
	}
	
	/** 
	 * Method that returns the pack 
	 */
	public void sortCards() {
		int length =this.pack.size();
		Card temp;
		int rand;
		
		for(int i= length-1;i>=0;i--){
			rand = (int)(Math.random()*i + 0);
			temp = this.pack.get(rand);
			this.pack.set(rand, this.pack.get(i));
			this.pack.set(i, temp);
		}
	}


}
