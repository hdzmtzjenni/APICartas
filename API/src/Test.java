

import java.util.ArrayList;
import java.util.List;

import game.BlackJackGame;
import game.BlackJackUserPlayer;
import game.Card;
import game.CardGame;
import game.Player;


public class Test {

	public static void main(String[] args) {
		
		CardGame blackjack = new BlackJackGame();
		Player player4 = BlackJackGame.createIntelligentPlayer();
		Player player5 = BlackJackGame.createStuplidPlayer();
		Player player6 = new BlackJackUserPlayer();
		Player player7 = new BlackJackUserPlayer();
		Player player8 = new BlackJackUserPlayer();
		Player player9 = new BlackJackUserPlayer();
		

		blackjack.addPlayer("Gabo",player6);
		blackjack.addPlayer("Jenni",player7);
		blackjack.addPlayer("Joseph",player8);
		blackjack.addPlayer("Anna",player9);
		blackjack.start();
		
		blackjack.playGame();
			
		ArrayList<Player> winners = blackjack.getWinner();
		System.out.printf("\n Winner/Winners: %s \n",winners.toString());
			 	
		
	}

}
