

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import game.BlackJackGame;
import game.BlackJackUserPlayer;
import game.Card;
import game.CardGame;
import game.PackOfCards;
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
	

		blackjack.addPlayer("Dani",player6);
		blackjack.addPlayer("Jenni",player7);
		blackjack.addPlayer("Joseph",player8);
		blackjack.addPlayer("Anna",player9);
		blackjack.start();

		blackjack.playGame();
			
		ArrayList<Player> winners = blackjack.getWinner();
		System.out.printf("\n Winner/Winners: %s \n",winners.toString());
		
			 	
		//Volvamos a jugar Blackjack con los mismos jugadores
		blackjack.start();// vuelve a revolver y repartir, el estatus de cada jugador se reinicia
		blackjack.playGame();
			
		winners = blackjack.getWinner();
		System.out.printf("\n Winner/Winners: %s \n",winners.toString());

		
		
	}
}
