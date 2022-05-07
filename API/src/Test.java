import game.BlackJackGame;
import game.CardGame;
import game.PackOfCards;
import game.Player;
import game.PokerGame;
import game.UserPlayer;

public class Test {

	public static void main(String[] args) {
		// PackOfCards a = new PackOfCards();
		// a.startPack();
		// System.out.println(a.getPack().toString());
		// a.sortCards();
		// System.out.println(a.getPack().toString());
		
		// System.out.println("\n\n\n");

		CardGame blackjack = new BlackJackGame();
		Player player4 = BlackJackGame.createIntelligentPlayer();
		Player player5 = ;
		Player player6 = new UserPlayer();
		CardGame poker = new PokerGame();
		poker.addPlayer("oli", player4);
		blackjack.addPlayer("John", player4);
		blackjack.addPlayer("Mary", player5);
		blackjack.addPlayer("Joseph",player6);
		blackjack.addPlayer("Anna",BlackJackGame.createIntelligentPlayer());
		System.out.println(BlackJackGame.playerList.size());
		
	}

}
