
import java.util.ArrayList;
import game.BlackJackGame;
import game.BlackJackUserPlayer;
import game.CardGame;
import game.Player;
import game.PokerGame;

public class Test {

	public static void main(String[] args) {
		
		Player player1 = PokerGame.createPairPlayer();
		CardGame blackjack = new BlackJackGame();
		Player player4 = BlackJackGame.createIntelligentPlayer();
		Player player5 = BlackJackGame.createFoolPlayer();
		Player player6 = new BlackJackUserPlayer();

		blackjack.addPlayer("John",player4);
		blackjack.addPlayer("Mary",player5);
		blackjack.addPlayer("Joseph",player6);
		blackjack.addPlayer("Anna",BlackJackGame.createIntelligentPlayer());
		blackjack.start();
		blackjack.playGame();

		ArrayList<Player> winners = blackjack.getWinner();
		System.out.printf("\n Winner/Winners: %s \n",winners.toString());

		//Volvamos a jugar Blackjack con los mismos jugadores
		blackjack.start();// vuelve a revolver y repartir, el estatus de cada jugador se reinicia
		blackjack.playGame();
			
		winners = blackjack.getWinner();
		System.out.printf("\n Winner/Winners: %s \n",winners.toString());

		// Volvamos a jugar Blackjack con otros jugadores
		blackjack.reset();// mismo juego, ya no hay jugadores
		blackjack.addPlayer("Mary", player6);
		blackjack.addPlayer("Juan", player1);// error de sintaxis: player1 no sabe jugar Blackjack (no es BlackjackPlayer)
		blackjack.addPlayer("Mary", player5);// Mary ya esta en el juego. Deciden ustedes que hacer: lanzar excepcion, ignorar esta llamada, o reemplazar player6 por player5
		blackjack.start();
		blackjack.playGame();
		
	}
}
