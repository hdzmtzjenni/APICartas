package game;

import java.util.ArrayList;

/**
 * @author jenniferh
 * 
 *
 */
public class BlackJackGame extends CardGame {
	public static ArrayList<Player> playerList = new ArrayList<>() ;
	public static final int MAX_PLAYERS= 5;
	public static final int MIN_PLAYERS= 2;
	
	/**
	 * 
	 */
	public BlackJackGame(){
	}

	@Override
	public void winConditions() {
	}

	@Override
	public boolean endGame() {
		return false;
	}

	@Override
	public Player getWinner() {
		return null;
	}
	
	public void reset() {
		
	}
	
	public Player nexPlayer() {
		return null;
	}
	
	@Override
	public void addPlayer(String name, Player player) {
		player.name= name;
		playerList.add(player);

	}
	
	public static IntelligentPlayer createIntelligentPlayer() {
		return new IntelligentPlayer();
	}
	
	public static StuplidPlayer createStuplidPlayer() {
		return new StuplidPlayer();

	}
	
	@Override
	public void removePlayer(String name) {
		for (int i = 0; i<playerList.size();i++) {
			Player player = playerList.get(i);
			if(player.name == name) playerList.remove(i);
		}
	}

}
