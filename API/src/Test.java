

import java.util.List;

import game.BlackJackGame;
import game.Card;
import game.CardGame;
import game.Player;
import game.PokerPlayer;
import game.UserPlayer;


public class Test {

	public static void main(String[] args) {
		
		CardGame blackjack = new BlackJackGame();
		Player player4 = BlackJackGame.createIntelligentPlayer();
		Player player5 = BlackJackGame.createStuplidPlayer();
		Player player6 = new UserPlayer();

		blackjack.addPlayer("John",player4);
		blackjack.addPlayer("Mary",player5);
		blackjack.addPlayer("Joseph",player6);
		blackjack.addPlayer("Anna",BlackJackGame.createIntelligentPlayer());
		blackjack.start();
		System.out.println(BlackJackGame.playerList.size());
		for (int i = 0; i < BlackJackGame.playerList.size(); i++) {
			Player p = blackjack.nextPlayer();
			List<Card> cards = p.getP_hand();
			System.out.println(BlackJackGame.playerList.get(i).getP_hand());
		}	
		System.out.println(BlackJackGame.getPlayerList().toString());
		
		
	}

}
