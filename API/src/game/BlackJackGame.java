package game;

import java.util.ArrayList;
import java.util.List;

import game.exception.NoPlayersException;
import game.exception.NullException;
import game.exception.SameNameException;


/*
 * 
 * @author Jennifer Hernandez,Gabriel Olvera
 *
 */


public class BlackJackGame extends CardGame {
	public static PackOfCards pack;
	protected int IndexNextPlayer=0;
	public static ArrayList<Player> playerList;
	public static ArrayList<Player> stillPlaying ;
	public static final int MAX_PLAYERS= 5;
	public static final int MIN_PLAYERS= 2;
	
	/*
	 *  Constructor de la clase BlackJackGame
	 */
	public BlackJackGame(){
		pack = new PackOfCards();
		playerList = new ArrayList<>();
		stillPlaying = new ArrayList<>();
	}

	/*
	 *  Método staic que crea un jugador del tipo IntelligentPlayer
	 * @return un jugador IntelligentPlayer
	 */
	public static IntelligentPlayer createIntelligentPlayer() {
		return new IntelligentPlayer();
	}
	public static FoolPlayer createStuplidPlayer() {
		return new FoolPlayer();

	}

	public static ArrayList<Player> getPlayerList() {
		return playerList;
	}
	public static void setPlayerList(ArrayList<Player> playerList) {
		BlackJackGame.playerList = playerList;
	}
	public int getIndexNextPlayer() {
		return IndexNextPlayer;
	}
	public void setIndexNextPlayer(int indexNextPlayer) {
		IndexNextPlayer = indexNextPlayer;
	}
	public static ArrayList<Player> getStillPlaying() {
		return stillPlaying;
	}
	public static void setStillPlaying(ArrayList<Player> stillPlaying) {
		BlackJackGame.stillPlaying = stillPlaying;
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

/**
 * Metodo que elimina a todos los jugadores
 */
	@Override
	public void reset() {
		playerList.removeAll(playerList);
	}

	@Override
	public boolean endGame() {
		int allReady = 0;
		for (Player p : playerList ) {
			if (p.handReady == true) {
				allReady ++;
			}
			if (allReady == playerList.size()) {
				return true; // debemos terminar la ronda
			}
			
		}
		return false; // aun no se termina la ronda 
	}

	@Override
	public ArrayList<Player> getWinner() { 
		for (Player player : playerList) {
			if (player.sumOfHand() <=21) {
				stillPlaying.add(player);
			}
		}
	
		ArrayList<Player> winners = new ArrayList<>(); //20,18,19,18
		int max=0;
		for (Player player1: stillPlaying) {
			if (player1.sumOfHand()>max) {
				max = player1.sumOfHand();
			}
		}
		for (Player player2 : stillPlaying) {
			if (player2.sumOfHand()==max) {
				winners.add(player2);
			}
		}
		return winners;
	}

	@Override
	public void addPlayer(String name, Player player){
		try {
			tryAddPlayer(name, player);
		} catch (NullException e) {
			e.printStackTrace();
		} catch (SameNameException e) {
            e.printStackTrace();
        }
	}

	public void tryAddPlayer(String name, Player player) throws NullException, SameNameException{
		if (player == null) throw new NullException();
		for (Player player1 : playerList) {
            if(player1.name == name) throw new SameNameException(name);
        }
		if(player instanceof BlackJackPlayer  ) {
			player.name= name;
			playerList.add(player);
		}
		else System.out.printf("\n%s  no sabe jugar BlackJack",name);
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

	public void tryStart() throws NoPlayersException{
		if (playerList.size()< MIN_PLAYERS) throw new NoPlayersException();
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

	@Override
	public void playGame() {
		try {
			tryGame();
		} catch (NoPlayersException e) {
			e.printStackTrace();
		}

		while(!endGame() && playerList.size()>=MIN_PLAYERS) {
			Player p = nextPlayer();// John, Mary, Joseph, Anna, John, Mary, ...
			p.play();
			List<Card> cards = p.getP_hand();
			System.out.println(cards);
		}
	}

	public void tryGame() throws NoPlayersException{
		if (playerList.size()<MIN_PLAYERS) {
			throw new NoPlayersException();
		}
	}

}
