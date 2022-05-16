import java.util.ArrayList;

import game.BlackJackGame;
import game.CardGame;
import game.Player;
import game.PokerGame;
import game.PokerUserPlayer;

public class TestPoker {
    public static void main(String[] args) {
        CardGame poker = new PokerGame();
        Player player1 = new PokerUserPlayer();
        Player player2 = PokerGame.createPairPlayer();
        Player player3 = PokerGame.createRandomPlayer();
        
        Player player6 = BlackJackGame.createFoolPlayer();
        
        poker.addPlayer("Jenni",player1);
        poker.addPlayer("Gabo", player2);
        poker.addPlayer("Pedrito", player3);
   
        poker.start();// revuelve cartas, reparte cartas 
        poker.playGame();
        
        ArrayList<Player> winners = poker.getWinner();
		System.out.printf("\n Winner/Winners: %s \n",winners.toString());
        

		poker.addPlayer("Paco", PokerGame.createPairPlayer());
		poker.removePlayer("Pedrito");
		poker.addPlayer("Mary", player6); // error de sintaxis: player6 no sabe jugar Poker (no es PokerPlayer)
		poker.addPlayer("Nulo", null); // excepcion: no se admiten apuntadores nulos
		poker.start();
		poker.playGame();

        winners = poker.getWinner();
		System.out.printf("\n Winner/Winners: %s \n",winners.toString());
        
		poker.reset();
		poker.start(); 
		poker.playGame();// Excepcion: no hay jugadores; por cada juego, definan minimo/maximo de jugadores
		
    }
}
