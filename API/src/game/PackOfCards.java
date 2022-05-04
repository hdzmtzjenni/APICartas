package game;
import java.util.ArrayList;

public class PackOfCards {

	ArrayList<Card> pack;
	
	public PackOfCards() {
		pack = new ArrayList<>();
	}

	public ArrayList<Card> getPack() {
		return pack;
	}

	public void setPack(ArrayList<Card> pack) {
		this.pack = pack;
	}
	
	public void startPack() {
		ArrayList<Suits> suits = new ArrayList<>();
		suits.add(Suits.HEART); suits.add(Suits.DIAMOND);
		suits.add(Suits.PIKES); suits.add(Suits.CLUBS);
		
		int count=1;
		for(int i =1; i<5; i++) {
			for(int j=1; j<14; j++) {
				Card e = new Card(count++,suits.get(i-1),j, null);
				pack.add(e);
			}
		}
	}
	
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
