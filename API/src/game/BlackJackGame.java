package game;

import java.util.ArrayList;
import java.util.List;

import game.exception.NoPlayersException;
import game.exception.NullException;
import game.exception.SameNameException;


/*
 * Class that manages how Black Jack is Played 
 * @author Jennifer Hernandez,Gabriel Olvera
 *
 */


public class BlackJackGame extends CardGame { // Extends Cardgame 
	public static PackOfCards pack; // Pack of Cards 
	protected int IndexNextPlayer=0;
	public static ArrayList<Player> playerList; // Players in game 
	public static ArrayList<Player> stillPlaying ; // Players that haven't loss 
	public static final int MAX_PLAYERS= 5; // Max Players
	public static final int MIN_PLAYERS= 2; // Min Players to play 
	
	/*
	 *   Public Constructor 
	 */
	public BlackJackGame(){
		pack = new PackOfCards();
		playerList = new ArrayList<>();
		stillPlaying = new ArrayList<>();
	}

	/*
	 *  Method that returns IntelligentPlayer 
	 * @return one player instance of  IntelligentPlayer
	 */
	public static IntelligentPlayer createIntelligentPlayer() {
		return new IntelligentPlayer();
	}
	
	// Method that returns Fool Player 
	public static FoolPlayer createFoolPlayer() {
		return new FoolPlayer(); // return Fool Player instance 

	}

	public static ArrayList<Player> getPlayerList() { // Return Player List 
		return playerList;
	}
	public static void setPlayerList(ArrayList<Player> playerList) { // Set Player List 
		BlackJackGame.playerList = playerList;
	}
	public int getIndexNextPlayer() { // Gets index of next Player to control the turns 
		return IndexNextPlayer;
	}
	public void setIndexNextPlayer(int indexNextPlayer) { // Set Index of the next player, used to reset it 
		IndexNextPlayer = indexNextPlayer;
	}
	public static ArrayList<Player> getStillPlaying() { // returns the players that havent loss 
		return stillPlaying;
	}
	public static void setStillPlaying(ArrayList<Player> stillPlaying) { // Set the players that havnt loss 
		BlackJackGame.stillPlaying = stillPlaying;
	}

	@Override // Override of method that determines the next player to play 
	public Player nextPlayer() {
		if(IndexNextPlayer==playerList.size()) { 
            this.IndexNextPlayer=0; 
        } 
		Player next = playerList.get(IndexNextPlayer);
		IndexNextPlayer++;

		return next;
	}


	@Override // Override the method that eliminates all players 
	public void reset() {
		playerList.removeAll(playerList);
	}

	@Override // Override of method that check if game ended 
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

	@Override // Override Of method get winner that gets who won 
	public ArrayList<Player> getWinner() { 
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

	@Override //Override of method that adds player 
	public void addPlayer(String name, Player player){
		try {
			tryAddPlayer(name, player); // Method that throws exception of null and same name 
		} catch (NullException e) {
			e.printStackTrace();
		} catch (SameNameException e) {
            e.printStackTrace();
        }
	}

	public void tryAddPlayer(String name, Player player) throws NullException, SameNameException{ // Function that checks exception 
		if (player == null) throw new NullException();
		for (Player player1 : playerList) { // Check each name 
            if(player1.name == name) throw new SameNameException(name);
        }
		if(player instanceof BlackJackPlayer  ) {
			player.name= name;
			playerList.add(player); // add if everything right 
		}
		else System.out.printf("\n%s  no sabe jugar BlackJack",name);
	}

	
	@Override // Override of method that removes player according to it's name 
	public void removePlayer(String name) {
		for (int i = 0; i<playerList.size();i++) {
			Player player = playerList.get(i);
			if(player.name == name) playerList.remove(i);
		}
	}

	@Override 
	public void start() { // override method that starts the game 
		System.out.println("\n==================== BLACK JACK GAME ====================");
		// Se inicializan los arreglos y se bajarean las cartas
		pack = new PackOfCards();
		pack.startPack();
		pack.sortCards();
		this.IndexNextPlayer=0;
		stillPlaying.removeAll(stillPlaying);
		for (Player player : playerList) {
			player.p_hand.removeAll(player.p_hand);
            player.turn=0;
            player.handReady=false;
		}
		try {
			tryStart();
		} catch (NoPlayersException e) {
			e.printStackTrace();
		}
		
	}

	public void tryStart() throws NoPlayersException{ // Function that throws the exception of No players
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

	@Override // Play Game overridem controls the whole game and 
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

	public void tryGame() throws NoPlayersException{ // throws No Players 
		if (playerList.size()<MIN_PLAYERS) {
			throw new NoPlayersException();
		}
	}

}
