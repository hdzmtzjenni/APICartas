package game;

import java.util.Collections;

/**
 * SubClass of Poker Player that always is looking to generate the next pair , if not it always passes 
 * @author Jennifer Hernandez,Gabriel Olvera
 */
public class PokerPairPlayer extends PokerPlayer{
    /**
	 * public Constructor 
	 */
    public PokerPairPlayer() { 
	}
	
	/**
	 * Override of the play function that each of Player Subclass has 
	 */
    @Override
	public void play() {
    	System.out.printf("\n\n----------------- Player %s -----------------",this.name);
    	while (!handReady) {// until Player not finish turn 
			//The cards inTable are shown in console 
            System.out.println("\nIn Table");
            System.out.println(PokerGame.getInTable());

			//The cards that the player has are printed too
            System.out.println("\nHand\n");
			Collections.sort(this.getP_hand());
			System.out.println(this.getP_hand());

			int lastcard = 5; // Last card to grab
			int value =6; // Value 
			int indexInTable = 1; // Index of table to swap
			int indexInHand =1; // index in hand 

			if (this.sumOfHand()== 2 || this.sumOfHand()==3 || this.sumOfHand()==4 || this.sumOfHand()==8 || this.sumOfHand()==7) { // if you already have a nice hand, Hand ready and pass turn 
				if (this.getMaxPlayableCard().getValue() >9) {
					System.out.printf("%s Hand Ready ",this.name);
					passTurn();
					break;
				}
				
			}
			
			for (Card c : PokerGame.getInTable()) { // get in table and check for pairs 
				indexInHand=1;
				for (Card ca : p_hand) {
					if( ca.getValue() == c.getValue()) { // Compares values 
						if (ca.getValue()>=value) { // Saves Value 
							if (lastcard == indexInHand) {
								PokerGame.swapCards(indexInTable, (lastcard-1), getP_hand()); // swaps from last card minus if it is lastcard index 
								this.turn++;
								return;
							}
							else{
								PokerGame.swapCards(indexInTable, lastcard, getP_hand()); // swaps from last card 
								this.turn++;
								return;
							}
						}
					
					}
					indexInHand++; // adds to index of hand
				}
				indexInTable ++; // Adds to index of table 
			}
			
			System.out.printf("%s Hand Ready ",this.name); // hand ready 
			passTurn(); // Pass turn 
			break;
			
    	}

		
	}
}
