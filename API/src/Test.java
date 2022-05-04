import game.PackOfCards;

public class Test {

	public static void main(String[] args) {
		PackOfCards a = new PackOfCards();
		a.startPack();
		System.out.println(a.getPack().toString());
		a.sortCards();
		System.out.println(a.getPack().toString());
		
	}

}
