package game;

import java.util.Collections;

public class PokerPairPlayer extends PokerPlayer{
    
    public PokerPairPlayer() {
    }

    @Override
	public void play() {
		// TODO Auto-generated method stub
    	System.out.printf("\n\n----------------- Player %s -----------------",this.name);
    	while (!handReady) {//Mientras el jugador no termine su turno
			System.out.printf("\nHand: %d\n",this.sumOfHand());
			System.out.println(this.getP_hand());
			Collections.sort(p_hand);
			int lastcard = 5;
			int indexInTable = 0;
			for (Card c : PokerGame.getInTable()) {
				for (Card ca : p_hand) {
					if( ca.getValue() == c.getValue()) {
						PokerGame.swapCards(indexInTable, lastcard, getP_hand());
						this.turn++;
		                break;
					}
					
				}
				indexInTable ++;
			}
			passTurn();
			
			
    	}
    	
    	
			
			
		
		
	}
}
