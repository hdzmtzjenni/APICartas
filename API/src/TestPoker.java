import game.CardGame;
import game.Player;
import game.PokerGame;
import game.PokerUserPlayer;

public class TestPoker {
    public static void main(String[] args) {
        CardGame poker = new PokerGame();

        Player player1 = new PokerUserPlayer();
        Player player2 = new PokerUserPlayer();
        Player player3 = new PokerUserPlayer();
        
        poker.addPlayer("Juan",player1);
        poker.addPlayer("Maria", player2);
        poker.addPlayer("Jose",player3);

        poker.start();// revuelve cartas, reparte cartas  
        poker.playGame();
        
    }
}
