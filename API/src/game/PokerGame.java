package game;

import java.util.ArrayList;

public class PokerGame extends CardGame{
    public static ArrayList<Player> playerList = new ArrayList<>() ;
	public static final int MAX_PLAYERS= 5;
	public static final int MIN_PLAYERS= 2;

    public PokerGame(){
        
    }
    @Override
    public void winConditions() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean endGame() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Player getWinner() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void addPlayer(String name, Player player) {
        player.name= name;
		playerList.add(player);
    }
    
}
