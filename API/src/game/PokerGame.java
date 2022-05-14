package game;

import java.util.ArrayList;
import java.util.List;

public class PokerGame extends CardGame{
    public int IndexNextPlayer=-1;
    public static boolean falg=false;
    public PackOfCards pack;
    public static ArrayList<Player> playerList ;
    public static ArrayList<Player> stillPlaying;
    public static ArrayList<Card> inTable = new ArrayList<>() ;
	public static final int MAX_PLAYERS= 5;
	public static final int MIN_PLAYERS= 2;

    public PokerGame(){
        playerList = new ArrayList<>();
        stillPlaying = new ArrayList<>();
    }

    public static PokerSmartPlayer createSmartPlayer(){
        return new PokerSmartPlayer();
    }

    public static PokerRandomPlayer createRandomPlayer(){
        return new PokerRandomPlayer();
    }
    

    public static ArrayList<Card> getInTable() {
        return inTable;
    }

    public static void setInTable(ArrayList<Card> inTable) {
        PokerGame.inTable = inTable;
    }
    

    public int getIndexNextPlayer() {
        return IndexNextPlayer;
    }

    public void setIndexNextPlayer(int indexNextPlayer) {
        IndexNextPlayer = indexNextPlayer;
    }

    @Override
    public ArrayList<Player> getWinner() {
        ArrayList<Player> winners = new ArrayList<>(); //20,18,19,18
		int max=0;
		for (Player player1: playerList) {
			if (player1.sumOfHand()>max) {
				max = player1.sumOfHand();
			}
		}
		for (Player player2 : playerList) {
			if (player2.sumOfHand()==max) {
				winners.add(player2);
			}
		}
        return null;
    }

    @Override
    public void addPlayer(String name, Player player) {
        if(player instanceof PokerPlayer  ) {
            player.name=name;
			playerList.add(player);

		}
		else System.out.printf("Este player no sabe jugar Poker ");
		
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
        System.out.println("\n==================== POKER ====================");

        //Se inicializan todas las variables de los jugadores y de la baraja
        pack = new PackOfCards();
		pack.startPack();
		pack.sortCards();
		this.IndexNextPlayer=-1;
        stillPlaying.addAll(playerList);
        System.out.println(stillPlaying);

		for (Player player : playerList) {
			player.p_hand.removeAll(player.p_hand);
            player.turn=0;
            player.handReady=false;
		}

		//Se reparten 5 cartas a cada jugador para empezar el juego
		Card card;
		for (int i = 0; i< playerList.size(); i++) {
			for(int j=0; j<5; j++){
				card = pack.getPack().get(j);
				playerList.get(i).p_hand.add(card);
				pack.getPack().remove(j);
			}
		}

        //Se agregan 5 cartas a la mesa
        Card card1;
		for(int j=0; j<5; j++){
			card1 = pack.getPack().get(j);
            inTable.add(card1);
			pack.getPack().remove(j);
		}
        
    }
    @Override
    public void reset() {
		playerList.removeAll(playerList);
        
    }
    @Override
    public Player nextPlayer() {
        IndexNextPlayer++;
        if(IndexNextPlayer==stillPlaying.size()) { 
            this.IndexNextPlayer=0; 
        } 
		Player next = stillPlaying.get(IndexNextPlayer);

		return next;
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
    public void playGame() {

        while(!endGame()) {
            System.out.printf("\nI: %d",IndexNextPlayer);
            
			Player p = nextPlayer();// John, Mary, Joseph, Anna, John, Mary, ...
            System.out.printf("\nI: %d",IndexNextPlayer);

            p.play();
            System.out.printf("\nI: %d",IndexNextPlayer);
			List<Card> cards = p.getP_hand();
			System.out.println(cards);
            if(p.handReady){
                System.out.println("\n####### ULTIMA RONDA #######");
                Player p1=nextPlayer();// John, Mary, Joseph, Anna, John, Mary, ...
                while (p1!=p) {
                    p1.play();
                    cards = p1.getP_hand();
			        System.out.println(cards);
                    p1.handReady=true;
                    p1 = nextPlayer();
                }
                
                // stillPlaying.remove(IndexNextPlayer);
                // System.out.println(stillPlaying);
                // for (Player player: stillPlaying) {
                //     player.play();
                //     List<Card> cards = player.getP_hand();
			    //     System.out.println(cards);
                //     player.handReady=true;
                // }
            }
            
            

            
		}
    }

    public static void swapCards( int indexInTable, int indexHand ,ArrayList<Card> p_hand){
		Card temp= inTable.get(indexInTable-1);
		inTable.set(indexInTable-1, p_hand.get(indexHand-1));
		p_hand.set(indexHand-1, temp);
	}
    
    
}
