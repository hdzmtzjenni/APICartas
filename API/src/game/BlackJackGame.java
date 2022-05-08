package game;

import java.util.ArrayList;

/**
 * @author jenniferh
 * 
 *
 */
public class BlackJackGame extends CardGame {
	public static PackOfCards pack;
	protected int IndexNextPlayer=0;
	public static ArrayList<Player> playerList = new ArrayList<>() ;
	public static ArrayList<Player> stillPlaying = new ArrayList<>() ;
	public static final int MAX_PLAYERS= 5;
	public static final int MIN_PLAYERS= 2;
	
	/**
	 * 
	 */
	public BlackJackGame(){
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
	
	public static IntelligentPlayer createIntelligentPlayer() {
		return new IntelligentPlayer();
	}
	
	public static StuplidPlayer createStuplidPlayer() {
		return new StuplidPlayer();

	}


/**
 * Método que elimina a todos los jugadores
 */
	@Override
	public void reset() {
		playerList.removeAll(playerList);
	}

	@Override
	public boolean checkEndOfRounds(ArrayList<Player> players) {
		int allReady = 0;
		for (Player p : players ) {
			if (p.handReady == true) {
				allReady ++;
			}
			if (allReady == players.size()) {
				return true; // debemos terminar la ronda
			}
			
		}
		return false; // aun no se termina la ronda 
	}

	@Override
	public Player getWinner() { 
		return null;
	}

	@Override
	public void addPlayer(String name, Player player) {
		if(player instanceof BlackJackPlayer || player instanceof UserPlayer) {
			playerList.add(player);
		}
		else System.out.printf("Este player no sabe jugar BlackJack ");
		

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
	
	public void playBlackJack() {
		stillPlaying.clear();
		stillPlaying.addAll(playerList);
		Player p = stillPlaying.get(0); // Empezar a jugar con el primer jugador\
		while (checkEndOfRounds(stillPlaying)) {
			Boolean probableWinner = p.play(p.p_hand); // Todos los jugadores juegan con las cartas que se les dio, 
			if(probableWinner == false ) {
				stillPlaying.remove(p);
			}
			
			
			
		}
		
		
	}
	
	
	

}
