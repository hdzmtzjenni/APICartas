package game;

import java.util.Collections;

public class PokerPairPlayer extends PokerPlayer{
    
    public PokerPairPlayer() {
    }

    @Override
	public void play() {
    	System.out.printf("\n\n----------------- Player %s -----------------",this.name);
    	while (!handReady) {//Mientras el jugador no termine su turno
			//The cards inTable are shown in console 
            System.out.println("\nIn Table");
            System.out.println(PokerGame.getInTable());

			//The cards that the player has are printed too
            System.out.println("\nHand\n");
			Collections.sort(this.getP_hand());
			System.out.println(this.getP_hand());

			int lastcard = 5;
			int value =6;
			int indexInTable = 1;
			int indexInHand =1;

			if (this.sumOfHand()== 2 || this.sumOfHand()==3 || this.sumOfHand()==4 || this.sumOfHand()==8 || this.sumOfHand()==7) {
				if (this.getMaxPlayableCard().getValue() >9) {
					System.out.printf("%s Hand Ready ",this.name);
					passTurn();
					break;
				}
				
			}
			
			for (Card c : PokerGame.getInTable()) {
				indexInHand=1;
				for (Card ca : p_hand) {
					if( ca.getValue() == c.getValue()) {
						if (ca.getValue()>=value) {
							if (lastcard == indexInHand) {
								PokerGame.swapCards(indexInTable, (lastcard-1), getP_hand());
								this.turn++;
								return;
							}
							else{
								PokerGame.swapCards(indexInTable, lastcard, getP_hand());
								this.turn++;
								return;
							}
						}
					
					}
					indexInHand++;
				}
				indexInTable ++;
			}
			
			System.out.printf("%s Hand Ready ",this.name);
			passTurn();
			break;
			
    	}

		
	}
}
