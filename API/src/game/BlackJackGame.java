package game;

import java.util.Set;

/**
 * @author jenniferh
 *
 */
public class BlackJackGame extends CardGame {
	public Set<Player> playerList;
	public static final int MAX_PLAYERS= 5;
	public static final int MIN_PLAYERS= 2;
	
	/**
	 * 
	 */
	public BlackJackGame() {
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
	
	public void addPlayer(String name, Player player) {
		
	}
	
//	public IntelligentPlayer createIntelligentPlayer() {
//		
//	}
	
//	public StuplidPlayer createStuplidPlayer()() {
//		
//	}
	
	public void removePlayer(String name) {
		
	}

}
