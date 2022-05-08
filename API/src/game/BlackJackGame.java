package game;

import java.util.ArrayList;


/**
 * @author jenniferh
 * 
 *
 */
public class BlackJackGame extends CardGame {
	public PackOfCards pack;
	private ArrayList<Card> inTable;
	public static ArrayList<Player> playerList = new ArrayList<>() ;
	public static final int MAX_PLAYERS= 5;
	public static final int MIN_PLAYERS= 2;
	
	/**
	 * 
	 */
	public BlackJackGame(){
	}

	public void reset() {
		
	}
	
	public Player nexPlayer() {
		return null;
	}
	
	public static IntelligentPlayer createIntelligentPlayer() {
		return new IntelligentPlayer();
	}
	
	public static StuplidPlayer createStuplidPlayer() {
		return new StuplidPlayer();

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
		// Se inicializan los arreglos y se bajarean las cartas
		pack = new PackOfCards();
		inTable = new ArrayList<>();
		pack.startPack();
		pack.sortCards();
		for (Player player : playerList) {
			player.p_hand.removeAll(player.p_hand);
		}

		//Se reparten 2 cartas a cada jugador para empezar el juego
		ArrayList<Card> hand = new ArrayList<>();
		for (int i = 0; i< playerList.size(); i++) {
			for(int j=0; j<2; j++){
				hand.add(pack.getPack().get(j));
				inTable.add(pack.getPack().get(j));
				pack.getPack().remove(j);
			}
			playerList.get(i).p_hand = hand;
			// System.out.println(playerList.get(i).getP_hand());
			hand.removeAll(hand);

		}

		// System.out.println();
		// System.out.println(inTable.toString());
		// System.out.println();
		// Collections.sort(pack.getPack());
		// System.out.println(pack.getPack().toString());
		// System.out.println("\n size:"+pack.getPack().size());

	}

}
