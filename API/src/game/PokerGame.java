package game;

import java.util.ArrayList;

public class PokerGame extends CardGame{
    public int IndexNextPlayer=0;
    public static ArrayList<Player> playerList = new ArrayList<>() ;
	public static final int MAX_PLAYERS= 5;
	public static final int MIN_PLAYERS= 2;

    public PokerGame(){
        
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
    @Override
    public void removePlayer(String name) {
        for (int i = 0; i<playerList.size();i++) {
			Player player = playerList.get(i);
			if(player.name == name) playerList.remove(i);
		}
    }
    @Override
    public void start() {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void reset() {
		playerList.removeAll(playerList);
        
    }
    @Override
    public Player nextPlayer() {
        if(IndexNextPlayer==playerList.size()) { 
            this.IndexNextPlayer=0; 
        } 
		Player next = playerList.get(IndexNextPlayer);
		IndexNextPlayer++;

		return next;
    }
    
    
}
