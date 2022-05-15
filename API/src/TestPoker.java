import java.util.ArrayList;

import game.CardGame;
import game.Player;
import game.PokerGame;
import game.PokerUserPlayer;

public class TestPoker {
    public static void main(String[] args) {
        CardGame poker = new PokerGame();

        Player player1 = new PokerUserPlayer();
        Player player2 = PokerGame.createPairPlayer();
        
        
        
        poker.addPlayer("Jenni",player1);
        poker.addPlayer("Gabo", player2);
   
        System.out.println(PokerGame.playerList.get(1));
        // poker.addPlayer("Jose",player3);

        poker.start();// revuelve cartas, reparte cartas 
        poker.playGame();
        // ArrayList<Player> winners = poker.getWinner();
		// System.out.printf("\n Winner/Winners: %s \n",winners.toString());
        
     
        
        
    }
}
