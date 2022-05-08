
import java.util.Collections;

import game.BlackJackGame;
import game.CardGame;
import game.PackOfCards;
import game.Player;
import game.PokerGame;
import game.UserPlayer;


public class Test {

	public static void main(String[] args) {
		
		CardGame blackjack = new BlackJackGame();
		Player player4 = BlackJackGame.createIntelligentPlayer();
		Player player6 = new UserPlayer();
		CardGame poker = new PokerGame();
		poker.addPlayer("oli", player4);
		blackjack.addPlayer("John", player4);
		blackjack.addPlayer("Joseph",player6);
		blackjack.addPlayer("Anna",BlackJackGame.createIntelligentPlayer());
		System.out.println(BlackJackGame.playerList.size());
		
	}

}
