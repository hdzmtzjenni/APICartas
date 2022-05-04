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
		int count=0;
		for(int i =0; i<4; i++) {
			for(int j=0; i<13; i++) {
				pack.add(new Card(count++,Suits.CORAZON,j));
			}
		}
	}
	
	public static void main(String[] args) {
		PackOfCards a = new PackOfCards();
		a.startPack();
		System.out.println(a.getPack().toString());;
	}

	
	
}
