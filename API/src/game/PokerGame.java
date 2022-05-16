package game;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import game.exception.NoPlayersException;
import game.exception.NullException;
import game.exception.SameNameException;

/**
 * PokerGame is used to control the Game of Poker and also to control the turns, the playerlist and the environment of playing poker.
 * Poker Game is a subclass of CardGame so it inherits all the methods necessary 
 * @author Jennifer Hernandez,Gabriel Olvera
 */
public class PokerGame extends CardGame{
    public int IndexNextPlayer=-1; 
    public PackOfCards pack; // Initial Pack Of Cards 
    public static ArrayList<Player> playerList ; // PlayerList that were added to an instance that will play, only accepts PokerPlayer Subclasses 
    public static ArrayList<Card> inTable = new ArrayList<>() ; // Referring to the cards that will be available in the table to draw from 
	public static final int MAX_PLAYERS= 5; // MaxPlayers that can be added to a PokerGame Instance 
	public static final int MIN_PLAYERS= 2; // Minimun of Players that are needed to play

    /**
     * Constructor of PokerGame 
     */
    public PokerGame(){ 
        playerList = new ArrayList<>();
    }

    /**
     * Function that returns an instance of PokerSmartPlayer
     * @return an instance of Pair Player
     */
    public static PokerPairPlayer createPairPlayer(){ 
        return new PokerPairPlayer();
    }

    /**
     * Function that returns an instance of PokerRandomPlayer 
     * @return an instance of Random Player
     */
    public static PokerRandomPlayer createRandomPlayer(){ 
        return new PokerRandomPlayer();
    }
    
    /**
     * Function that returns the ArrayList<Card> in table 
     */
    public static ArrayList<Card> getInTable() { 
        return inTable;
    }

    /**
     * Function that adds to table the cards within ArrayList<Card> inTable 
     * @param inTable
     */
    public static void setInTable(ArrayList<Card> inTable) { 
        PokerGame.inTable = inTable;
    }
    
    /**
     * Returns the index of next Player 
     * @return indexNextPlayer
     */
    public int getIndexNextPlayer() { 
        return IndexNextPlayer;
    }

    /**
     * Set the marker on which Player is Next 
     * @param indexNextPlayer
     */
    public void setIndexNextPlayer(int indexNextPlayer) { 
        IndexNextPlayer = indexNextPlayer;
    }
    
    /**
     * Function that based on an int it returns the PokerRanking instance that is the same of the value of int 
     * @param ranking
     * @return Instance of PokerRanking
     */
    public PokerRanking getRankingFromInt( int ranking) { 
    		
    	PokerRanking PR;
    	
    	 switch (ranking) {
         case 1:  PR = PokerRanking.HighCard; // Lowest Possible 
                  break;
         case 2:  PR = PokerRanking.OnePair;
                  break;
         case 3:  PR = PokerRanking.TwoPair;
                  break;
         case 4:  PR = PokerRanking.ThreeOfAKind;
                  break;
         case 5:  PR = PokerRanking.Straight;
                  break;
         case 6:  PR = PokerRanking.Flush;
                  break;
         case 7:  PR = PokerRanking.FullHouse;
                  break;
         case 8:  PR = PokerRanking.FourOfAKind;
                  break;
         case 9:  PR = PokerRanking.StraightFlush;
                  break;
         case 10: PR = PokerRanking.RoyalFlush; // Highest Possible 
                  break;
         default: PR = PokerRanking.HighCard; // Default Case 
                  break;
     }
    	 return PR; 
    }

    /**
     * Override of function within CardGame that determines the winner. 
     */
    @Override 
    public ArrayList<Player> getWinner() {
        System.out.println("\n###### GAME END ######");
        ArrayList<Player> stillPlaying = new ArrayList<>(); // Creates an arraylist of players that will be used to determine which of the players have the same value
		int max=0; // Sum Variable to determine the Max Value of Hand
        // The Max Value of hand is calculated 
		for (Player player1: playerList) { // for each player in playerlist(All Players that have played )
			PokerRanking PR = getRankingFromInt(player1.sumOfHand()); // Determines as a enum PokerRanking instance the value of the hand 
            System.out.printf("Player %s has: %s of %s\n",player1.name, PR.toString(),player1.getMaxPlayableCard().getValueString()); // Print of Play using to String of enum and attribute MaxPlayableValue 
			if (player1.sumOfHand()>max) {
				max = player1.sumOfHand(); // Determines the max value of hand
			}
		}

        // If two players have the same hand they are added to stillPlaying
		for (Player player2 : playerList) { // For each of all that have played 
			if (player2.sumOfHand()==max) { // if same to max 
				stillPlaying.add(player2); // Add to still playing
			}
		}
        ArrayList<Player> winners = new ArrayList<>();  // New List of winners , if two players have the same hand, only the one with highest maxPlayableValue will be added

        //Are there any more than one possible winner?
        if(stillPlaying.size()>1){
            max= 0; // Max is set to 0 
            //For each of players within StillPlaying 
            for (Player player : stillPlaying) {
                if (player.getMaxPlayableCard().getValue()>max) { // Determines which is the  highest MaxPlayableValue of each Player 
                    max=player.getMaxPlayableCard().getValue(); // If it finds a higher one, Max is swapped 
                }
            }

            //For each player that is on stillPlaying, the ones that are equal to maxPlayableValue are added to winners. 
            for (Player player2 : stillPlaying) {
                if (player2.getMaxPlayableCard().getValue()==max) {
                    winners.add(player2); // Add to Winners 
                }
            }
        }else{
            winners = stillPlaying; // if it is only one player it is the same as winner 
        }
        return winners; // return the winners, ties are possible in some cases, the players with same PowerRanking and same MaxPlayableValue win 
    }
 
    /**
     * Override of method AddPlayer of CardGme 
     */
    @Override 
    public void addPlayer(String name, Player player) {
        try { // Exception management 
			tryAddPlayer(name, player); // use of TryAddPlayer that throws NullException and SameNameException
		} catch (NullException e) { // No Null Pointers
			e.printStackTrace();
		} catch (SameNameException e) { // No players with same name 
            e.printStackTrace();
        }
    }

    /**
     * Exception Thrower that uses NullException and SameNameExcpetion
     * @param name
     * @param player
     * @throws NullException
     * @throws SameNameException
     */
	private void tryAddPlayer(String name, Player player) throws NullException, SameNameException{ 
		if (player == null) throw new NullException(); // Exception Thrown when detecterd a null player 
        for (Player player1 : playerList) {
            if(player1.name == name) throw new SameNameException(name); // Exception Thrown when players have same name 
        }
		if(player instanceof PokerPlayer  ) { // Onlu Adds if it's a subclass of PokerPlayer 
            player.name=name;
			playerList.add(player); // Adds to PlayerList 

		}
		else System.out.printf("\n%s doesn't know how to play poker\n",name); // Console Print
	}
    
    /**
     * Override of method Remove Player of CardGame 
     */
    @Override 
    public void removePlayer(String name) { // Removes Player based on name 
        for (int i = 0; i<playerList.size();i++) { 
			Player player = playerList.get(i); // Gets instance of players within Playerlist 
			if(player.name == name) playerList.remove(i); // If name is equal to the one received, it is removed. 
		}
    }

    /**
     * Override of method start of CardGame 
     */
    @Override 
    public void start(){
        System.out.println("\n==================== POKER ===================="); // Console Output 

        //Variables of all players are initialized and the card are sorted 
        pack = new PackOfCards(); // new pack of cards that ensures that we are only playing with one pack and no repeated cards 
		pack.startPack(); //Adds card to Pack
		pack.sortCards(); // Sorts pack once initialized 
		setIndexNextPlayer(-1); 

		for (Player player : playerList) { // For each player all Cards that were previous in p_hand are removed 
			player.p_hand.removeAll(player.p_hand); //reset
            player.setTurn(0);; //reset
            player.setHandReady(false);; //reset
		}

        try {
            tryStart(); // Method that throws NoPlayerException
        } catch (NoPlayersException e) {
            e.printStackTrace(); // Print error 
        }

        //5 cards are added to the inTable. 
        Card card1;
		for(int j=0; j<5; j++){
			card1 = pack.getPack().get(j);
            inTable.add(card1);
			pack.getPack().remove(j); // each added each eliminated 
		}
        
    }

    /**
     * Method that throws NoPlayersException 
     * @throws NoPlayersException
     */
    private void tryStart() throws NoPlayersException{ 
        if(playerList.size()<MIN_PLAYERS) throw new NoPlayersException(); // if the list size is less than min_players throw the exception 
        Card card; 
        for (int i = 0; i< playerList.size(); i++) { // Add Card one by one and eliminate them from pack 
            for(int j=0; j<5; j++){
                card = pack.getPack().get(j);
                playerList.get(i).p_hand.add(card);
                pack.getPack().remove(j); 
            }
        }
    }

    /**
     * Override reset method from CardGame 
     */
    @Override
    public void reset() { 
		playerList.removeAll(playerList); // all Players are removed
        
    }

    /**
     * Override next player method from CardGame 
     */
    @Override
    public Player nextPlayer(){ 
        IndexNextPlayer++; // add to counter
        if(IndexNextPlayer==playerList.size()) { 
            setIndexNextPlayer(0); // resets the counter 
        } 
		Player next = playerList.get(IndexNextPlayer);// Get Instance of Player 

		return next; //Return Instance 
    }

    /**
     * Function that determines when the game ends 
     */
    @Override
    public boolean endGame() { 
        int allReady = 0; // Variable that knows if everyone is ready 
		for (Player p : playerList ) {// For each player check if handReady 
			if (p.handReady == true) {
				allReady ++; //sumador de allready
			}
			if (allReady == playerList.size()) { // know if everyone is ready 
				return true; // debemos terminar la ronda
			}
			
		}
		return false; // aun no se termina la ronda 
    }

    /**
     * Override PlayGame function from Cardgame 
     */
    @Override
    public void playGame() { 
        //The Game runs until endGame doesnt happen 
        
        while(!endGame()) { // while endgame does not return false 
			Player p = nextPlayer(); // get nextplayer
            p.play(); // execute play from each player 
			List<Card> cards = p.getP_hand(); // get each p_hand 
            Collections.sort(cards); // sort hand

			System.out.println("\nHand \n"+ cards); // print hand 

            // If one Player has hand ready , is last round for everyone 
            if(p.handReady){
                System.out.println("\n####### LAST ROUND #######");
                Player p1=nextPlayer();

                //While p be different from the player that put p_hand ready first it still gives turns 
                while (p1!=p) { 
                    p1.play();
                    cards = p1.getP_hand();
			        System.out.println("\nHand \n"+ cards); // print hand 
                    p1.setHandReady(true); // also put handready true 
                    p1 = nextPlayer();
                } 
            }
		}
    }

    /**
     * Method that takes indexes from arrayList cards and swaps them. Method takes indexes as [1-5]
     * @param indexInTable
     * @param indexHand
     * @param p_hand
     */
    public static void swapCards( int indexInTable, int indexHand ,ArrayList<Card> p_hand){
		Card temp= inTable.get(indexInTable-1); // get index and accomodates it
		inTable.set(indexInTable-1, p_hand.get(indexHand-1)); //gets catd
		p_hand.set(indexHand-1, temp); //puts card 
	}
    
    
}
