package game;

import java.util.Collections;

public class PokerPlayer extends Player {

	@Override
	public int sumOfHand() {
		// TODO Auto-generated method stub
		PokerRanking PR;
		Card c1; 
		Card c2;
		Card c3;
		Card c4;
		Card c5;
	
		//p_hand sort 
		
		Collections.sort(this.getP_hand());
		
		// card division
		
		c1 = p_hand.get(0);
		c2 = p_hand.get(1);
		c3 = p_hand.get(2);
		c4 = p_hand.get(3);
		c5 = p_hand.get(4);
		
		// Royal Flush 
		if (this.sameSuit()) {
			if(c1.getValue() == 1 && c2.getValue() == 10  && c3.getValue() == 11  && c4.getValue() == 12  && c5.getValue() == 13 ) PR = PokerRanking.RoyalFlush;
	
		}
		
		// Straight Flush 
		if (this.sameSuit()) {
			if(c2.getValue() == (c1.getValue()+1)  && c3.getValue() == (c1.getValue()+2)  && c4.getValue() == (c1.getValue()+3)  && c5.getValue() == (c1.getValue()+4)) PR = PokerRanking.StraightFlush;
		}
		
		return 0;
		
		
	}
	

	@Override
	public Boolean play() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	
}
