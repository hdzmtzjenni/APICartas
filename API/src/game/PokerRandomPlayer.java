package game;

import java.util.Collections;

// SubClass Of Poker Player of a Random Poker Player that based on probabilities changes cards and also has a 10 percent chance of ending round 
public class PokerRandomPlayer extends PokerPlayer {
    
    public PokerRandomPlayer() { // Public Constructor 
    }
    
    private int getRandomIndex(int randomInt) { // Get a random index depending in which number the random falled, every index has 20% chance 
    	int returnIndex =0;
    	if (randomInt >=0 && randomInt<= 20) {
			returnIndex = 1;
		}
    	if (randomInt >20 && randomInt<= 40) {
			returnIndex = 2;
		}
    	if (randomInt >40 && randomInt<= 60) {
			returnIndex = 3;
		}
    	if (randomInt >60 && randomInt<= 80) {
			returnIndex = 4;
		}
    	if (randomInt >80 && randomInt<= 80) {
			returnIndex = 5;
    	}
    	
		return returnIndex;
    }
    	

    @Override // Override the Play Method , playing random 
	public void play() { 
		// TODO Auto-generated method stub
    	
    	System.out.printf("\n\n----------------- Player %s -----------------",this.name);
    	while (!handReady) {// until Player not finish turn 
			//The cards inTable are shown in console 
            System.out.println("\nIn Table");
            System.out.println(PokerGame.getInTable());

			//The cards that the player has are printed too
            System.out.println("\nHand\n");
			Collections.sort(this.getP_hand());
			System.out.println(this.getP_hand());
			
			int getRandomValue = (int) (Math.random()*(100-1)) + 1; // Get Random Number 
			if (getRandomValue>=0 && getRandomValue<= 10) { // 10%chance of ending turn right away
				
				passTurn();
				break;
				
			}else {
				int RandomIndex1 = (int) (Math.random()*(100-1)) + 1; // Get Random Number 
				int RandomIndex2 = (int) (Math.random()*(100-1)) + 1; // Get Random Number 
				PokerGame.swapCards(getRandomIndex(RandomIndex1), getRandomIndex(RandomIndex2), p_hand); // swap random 
				this.turn ++ ;
				return;
			}
			
    	}

		
		
	}
}
