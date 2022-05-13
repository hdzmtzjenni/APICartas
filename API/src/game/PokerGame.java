package game;

import java.util.ArrayList;

public class PokerGame extends CardGame{
    public int IndexNextPlayer=0;
    public PackOfCards pack;
    public static ArrayList<Player> playerList = new ArrayList<>() ;
    public static ArrayList<Card> inTable = new ArrayList<>() ;
	public static final int MAX_PLAYERS= 5;
	public static final int MIN_PLAYERS= 2;

    public PokerGame(){
        
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

    @Override
    public ArrayList<Player> getWinner() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void addPlayer(String name, Player player) {
        if(player instanceof PokerPlayer  ) {
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
        //Se inicializan todas las variables de los jugadores y de la baraja
        pack = new PackOfCards();
		pack.startPack();
		pack.sortCards();
		this.IndexNextPlayer=0;

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
        if(IndexNextPlayer==playerList.size()) { 
            this.IndexNextPlayer=0; 
        } 
		Player next = playerList.get(IndexNextPlayer);
		IndexNextPlayer++;

		return next;
    }

    @Override
    public boolean endGame() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void playGame() {
        // TODO Auto-generated method stub
    	
    	
        
    }
    
    
}
