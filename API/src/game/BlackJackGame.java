package game;

import java.util.ArrayList;
import java.util.List;

import game.exception.NoPlayersException;
import game.exception.NullException;
import game.exception.SameNameException;

/** 
 * Class that manages how Black Jack is Played 
 * Extends Cardgame 
 * @author Jennifer Hernandez,Gabriel Olvera
 */
public class BlackJackGame extends CardGame { 
	protected static PackOfCards pack; // Pack of Cards 
	protected int IndexNextPlayer=0;
	protected static ArrayList<Player> playerList; // Players in game 
	protected static ArrayList<Player> stillPlaying ; // Players that haven't loss 
	public static final int MAX_PLAYERS= 5; // Max Players
	public static final int MIN_PLAYERS= 2; // Min Players to play 
	
	/** 
	 *   Public Constructor of BlackJackGame
	 */
	public BlackJackGame(){
		pack = new PackOfCards();
		playerList = new ArrayList<>();
		stillPlaying = new ArrayList<>();
	}

	/**
	 *  Method that returns IntelligentPlayer 
	 * @return one player instance of  IntelligentPlayer
	 */
	public static BlackJackIntelligentPlayer createIntelligentPlayer() {
		return new BlackJackIntelligentPlayer();
	}
	
	/**
	 * Method that returns Fool Player
	 * @return a new player instance of FoolPlayer
	 */ 
	public static BlackJackFoolPlayer createFoolPlayer() {
		return new BlackJackFoolPlayer(); // return Fool Player instance 

	}

	/**
	 * Method that returns an Array with the players
	 * @return playerList of blackJackGame
	 */
	public static ArrayList<Player> getPlayerList() { 
		return playerList;
	}

	/**
	 * Method that ser PlayerList
	 * @param playerList
	 */
	public static void setPlayerList(ArrayList<Player> playerList) { 
		BlackJackGame.playerList = playerList;
	}

	/**
	 * Gets index of next Player to control the turns 
	 * @return int of indexNextPlayer
	 */
	public int getIndexNextPlayer() { 
		return IndexNextPlayer;
	}

	/**
	 * Set Index of the next player, used to reset it 
	 * @param indexNextPlayer
	 */
	public void setIndexNextPlayer(int indexNextPlayer) { 
		IndexNextPlayer = indexNextPlayer;
	}

	/**
	 * Method that returns the players that havent loss 
	 * @return Array of player that havent loss
	 */
	public static ArrayList<Player> getStillPlaying() { 
		return stillPlaying;
	}

	/**
	 * Set the players that havent loss 
	 * @param stillPlaying
	 */
	public static void setStillPlaying(ArrayList<Player> stillPlaying) { 
		BlackJackGame.stillPlaying = stillPlaying;
	}

	/**
	 * Override of method that determines the next player to play 
	 */
	@Override 
	public Player nextPlayer() {
		if(IndexNextPlayer==playerList.size()) { 
            setIndexNextPlayer(0);
        } 
		Player next = playerList.get(IndexNextPlayer);
		IndexNextPlayer++;

		return next;
	}

	/**
	 * Override the method that eliminates all players 
	 */
	@Override 
	public void reset() {
		playerList.removeAll(playerList);
	}

	/**
	 * Override of method that check if game ended 
	 */
	@Override 
	public boolean endGame() {
		int allReady = 0; // Sum 
		for (Player p : playerList ) {
			if (p.handReady == true) {// If all players are ready 
				allReady ++;
			}
			if (allReady == playerList.size()) {
				return true; // end of round 
			}
			
		}
		return false; // round still not finished  
	}

	/**
	 * Override Of method get winner that gets who won
	 */
	@Override  
	public ArrayList<Player> getWinner() { 
		System.out.println("\n###### GAME END ######");
		for (Player player : playerList) {
			if (player.sumOfHand() <=21) {
				stillPlaying.add(player); // adds to still playing to know how much winners 
			} 
		}
	
		ArrayList<Player> winners = new ArrayList<>(); // New List of winners 
		int max=0;
		for (Player player1: stillPlaying) {
			if (player1.sumOfHand()>max) {  // Max Value 
				max = player1.sumOfHand();
			}
		}
		for (Player player2 : stillPlaying) {
			if (player2.sumOfHand()==max) { // Check if Every player has max (21)
				winners.add(player2);
			}
		}
		return winners; // Return players that have 21 
	}

	/**
	 * Override of method that adds player 
	 */
	@Override 
	public void addPlayer(String name, Player player){
		try {
			tryAddPlayer(name, player); // Method that throws exception of null and same name 
		} catch (NullException e) {
			e.printStackTrace();
		} catch (SameNameException e) {
            e.printStackTrace();
        }
	}

	/**
	 * Function that checks exception 
	 * @param name
	 * @param player
	 * @throws NullException
	 * @throws SameNameException
	 */
	private void tryAddPlayer(String name, Player player) throws NullException, SameNameException{ 
		if (player == null) throw new NullException();
		for (Player player1 : playerList) { // Check each name 
            if(player1.name == name) throw new SameNameException(name);
        }
		if(player instanceof BlackJackPlayer  ) {
			player.name= name;
			playerList.add(player); // add if everything right 
		}
		else System.out.printf("\n%s  doesn't know how to play black jack",name);
	}

	
	/**
	 * Override of method that removes player according to it's name 
	 */
	@Override 
	public void removePlayer(String name) {
		for (int i = 0; i<playerList.size();i++) {
			Player player = playerList.get(i);
			if(player.name == name) playerList.remove(i);
		}
	}

	/**
	 * override method that starts the game 
	 */
	@Override 
	public void start() { 
		System.out.println("\n==================== BLACK JACK GAME ====================");
		// Se inicializan los arreglos y se bajarean las cartas
		pack = new PackOfCards();
		pack.startPack();
		pack.sortCards();
		setIndexNextPlayer(0);
		stillPlaying.removeAll(stillPlaying);
		for (Player player : playerList) {
			player.p_hand.removeAll(player.p_hand);
            player.setTurn(0);
            player.setHandReady(false);
		}
		try {
			tryStart();
		} catch (NoPlayersException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * Function that throws the exception of No players
	 * @throws NoPlayersException
	 */
	private void tryStart() throws NoPlayersException{ 
		if (playerList.size()< MIN_PLAYERS) throw new NoPlayersException(); // Check less than min 
		//Se reparten 2 cartas a cada jugador para empezar el juego
		Card card;
		for (int i = 0; i< playerList.size(); i++) {
			for(int j=0; j<2; j++){
				card = pack.getPack().get(j);
				playerList.get(i).p_hand.add(card);
				pack.getPack().remove(j);
			}
		}
	}

	/**
	 * Play Game overridem controls the whole game 
	 */
	@Override 
	public void playGame() {
		try {
			tryGame();
		} catch (NoPlayersException e) { // Check no players 
			e.printStackTrace();
		}

		while(!endGame() && playerList.size()>=MIN_PLAYERS) {
			Player p = nextPlayer(); // Changes turn 
			p.play();
			List<Card> cards = p.getP_hand();
			System.out.println(cards);
		}
	}

	/**
	 * throws No Players 
	 * @throws NoPlayersException
	 */
	private void tryGame() throws NoPlayersException{ 
		if (playerList.size()<MIN_PLAYERS) {
			throw new NoPlayersException();
		}
	}

}
