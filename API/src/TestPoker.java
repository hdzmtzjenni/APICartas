import java.util.ArrayList;

import game.CardGame;
import game.Player;
import game.PokerGame;
import game.PokerUserPlayer;
import game.exception.NoPlayersException;

public class TestPoker {
    public static void main(String[] args) {
        CardGame poker = new PokerGame();

        Player player1 = new PokerUserPlayer();
        Player player2 = new PokerUserPlayer();
        Player player3 = new PokerUserPlayer();
        
        poker.addPlayer("Jenni",null);
        // poker.addPlayer("Norma", player2);
        // poker.addPlayer("Jose",player3);

        try {
            poker.start();// revuelve cartas, reparte cartas 
            poker.playGame();
            ArrayList<Player> winners = poker.getWinner();
		    System.out.printf("\n Winner/Winners: %s \n",winners.toString());
        } catch (NoPlayersException e) {
            System.out.println(e);
        }
     
        
        
    }
}
