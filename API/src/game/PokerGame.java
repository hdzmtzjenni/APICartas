package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PokerGame extends CardGame{
    public int IndexNextPlayer=-1;
    public PackOfCards pack;
    public static ArrayList<Player> playerList ;
    public static ArrayList<Card> inTable = new ArrayList<>() ;
	public static final int MAX_PLAYERS= 5;
	public static final int MIN_PLAYERS= 2;

    public PokerGame(){
        playerList = new ArrayList<>();
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
        ArrayList<Player> stillPlaying = new ArrayList<>();
		int max=0;
        //Se calcula la mano más alta
		for (Player player1: playerList) {
            System.out.printf("\nPlayer %s has: %d",player1.name,player1.sumOfHand());
			if (player1.sumOfHand()>max) {
				max = player1.sumOfHand();
			}
		}

        //Si dos jugadores tienen la misma mano se añaden a StillPlaying
		for (Player player2 : playerList) {
			if (player2.sumOfHand()==max) {
				stillPlaying.add(player2);
			}
		}
        ArrayList<Player> winners = new ArrayList<>(); 

        //Se evalua si son más de un jugador los que tienen la misma mano
        if(stillPlaying.size()>1){
            max= 0;
            //Si son más de un jugador se evalua dentro de su mano la mayor carta
            for (Player player : stillPlaying) {
                if (player.maxPlayableValue>max) {
                    max=player.maxPlayableValue;
                }
            }

            //se agrega a winner el jugador o jugadores que tengan la carta más alta dentro de su mano
            for (Player player2 : stillPlaying) {
                if (player2.maxPlayableValue==max) {
                    winners.add(player2);
                }
            }
        }else{
            winners = stillPlaying;
        }
        return winners;
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
        if(IndexNextPlayer==playerList.size()) { 
            this.IndexNextPlayer=0; 
        } 
		Player next = playerList.get(IndexNextPlayer);

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
        //El juego corre mientras endGame no se cumpla
        while(!endGame()) {
			Player p = nextPlayer();
            p.play();
			List<Card> cards = p.getP_hand();
            Collections.sort(cards);

			System.out.println(cards);

            // Si el jugador quiso levantar la mano para terminar la jugada, se realiza el último turno de todos
            if(p.handReady){
                System.out.println("\n####### LAST ROUND #######");
                Player p1=nextPlayer();

                //Mientras que el player sea diferente al que quiso terminar se corre el ciclo
                //Ya que el que termina el juego no vuelve a jugar
                while (p1!=p) {
                    p1.play();
                    cards = p1.getP_hand();
			        System.out.println(cards);
                    p1.handReady=true;
                    p1 = nextPlayer();
                } 
            }
		}
    }

    public static void swapCards( int indexInTable, int indexHand ,ArrayList<Card> p_hand){
		Card temp= inTable.get(indexInTable-1);
		inTable.set(indexInTable-1, p_hand.get(indexHand-1));
		p_hand.set(indexHand-1, temp);
	}
    
    
}
