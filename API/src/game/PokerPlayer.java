package game;

import java.util.Collections;

// PokerPlayer is the subclass of Player that has the right functions to play Poker. This is the only subclass of player that can be included into a PokerGame. 

public class PokerPlayer extends Player {

	@Override
	public int sumOfHand() { // Function that returns the value based on PokerRanking of your hand 
		PokerRanking PR =PokerRanking.HighCard; // Create Instance of enum to save the value of Hand
		
		//p_hand sort 
		Collections.sort(this.getP_hand());  // SortCards using genericMethod thanks to the implementation of Comparable in Card Class 
		// card division in order 
		Card c1 = p_hand.get(0); // Lowest Card in Hand 
		Card c2 = p_hand.get(1);
		Card c3 = p_hand.get(2);
		Card c4 = p_hand.get(3);
		Card c5 = p_hand.get(4); // Highest Card in Hand
		
		// default value of MaxPlayableValue
		this.maxPlayableValue = c5.getValue();
		
		// Royal Flush 
		if (this.sameSuit()) {
			if(c1.getValue() == 1 && c2.getValue() == 10  && c3.getValue() == 11  && c4.getValue() == 12  && c5.getValue() == 13 ) {
				PR = PokerRanking.RoyalFlush;
				//MaxPlayableValue
				this.maxPlayableValue = 13;
				return PR.getRanking();
			}
		}
		
		// Straight Flush 
		if (this.sameSuit()) {
			if(c2.getValue() == (c1.getValue()+1)  && c3.getValue() == (c1.getValue()+2)  && c4.getValue() == (c1.getValue()+3)  && c5.getValue() == (c1.getValue()+4)){
				PR = PokerRanking.StraightFlush;
				//MaxPlayableValue
				this.maxPlayableValue = c5.getValue();
				return PR.getRanking();
			}
		}
		
		// Four Of A Kind
		if(c1.getValue() != c2.getValue()) {
			if(c2.getValue() == c3.getValue() && c3.getValue() == c4.getValue() && c4.getValue() == c5.getValue()){
				PR = PokerRanking.FourOfAKind;
				//MaxPlayableValue
				this.maxPlayableValue = c2.getValue();
				return PR.getRanking();
			}
		} else if (c1.getValue() == c2.getValue() && c2.getValue() == c3.getValue() && c3.getValue() == c4.getValue()){
			PR = PokerRanking.FourOfAKind;
			//MaxPlayableValue
			this.maxPlayableValue = c1.getValue();
			return PR.getRanking();
		}
			
		// Full House 
		if(c1.getValue() == c2.getValue() && c3.getValue() ==c4.getValue() && c4.getValue()==c5.getValue()){
			//MaxPlayableValue
			this.maxPlayableValue = c3.getValue(); // where the three of a kind is 
			PR = PokerRanking.FullHouse;
			return PR.getRanking();
		} else if(c1.getValue() == c2.getValue() && c2.getValue() ==c3.getValue() && c4.getValue()==c5.getValue()) {
			PR = PokerRanking.FullHouse;
			//MaxPlayableValue
			this.maxPlayableValue = c1.getValue(); // where the three of a kind is
			return PR.getRanking();
		}
		//Flush
		if(this.sameSuit()){
			PR = PokerRanking.Flush;
			//MaxPlayableValue
			this.maxPlayableValue = c5.getValue();
			return PR.getRanking();
		}

		//Straight
		if(c2.getValue()== c1.getValue()+1 && c3.getValue()==c2.getValue()+1 && c4.getValue()==c3.getValue()+1 && c5.getValue() ==c4.getValue()+1) {
			PR = PokerRanking.Straight;
			//MaxPlayableValue
			this.maxPlayableValue = c5.getValue();
			return PR.getRanking();
			
		}
		// Three of a Kind
		if(c1.getValue()==c2.getValue() && c2.getValue()==c3.getValue()){
			PR = PokerRanking.ThreeOfAKind;
			//MaxPlayableValue
			this.maxPlayableValue = c1.getValue();
			return PR.getRanking();
		} else if(c2.getValue()==c3.getValue() && c3.getValue()==c4.getValue()){
			PR = PokerRanking.ThreeOfAKind;
			//MaxPlayableValue
			this.maxPlayableValue = c2.getValue();
			return PR.getRanking();
		} else if(c3.getValue()==c4.getValue() && c4.getValue()==c5.getValue()) {
			PR = PokerRanking.ThreeOfAKind;
			//MaxPlayableValue
			this.maxPlayableValue = c3.getValue();
			return PR.getRanking();
		}

		//Two Pair
		if(c1.getValue()!= c2.getValue()){
			if(c2.getValue()==c3.getValue()){
				if(c4.getValue()==c5.getValue() && c3.getValue() != c4.getValue()) {
					PR = PokerRanking.TwoPair;
					//MaxPlayableValue
					this.maxPlayableValue = c4.getValue();		
					return PR.getRanking();			
				}
			}	
		}else if(c1.getValue()== c2.getValue()) {
			if (c3.getValue()!=c4.getValue()) {
				if(c4.getValue() ==c5.getValue()) {
					PR = PokerRanking.TwoPair;
					//MaxPlayableValue
					this.maxPlayableValue = c4.getValue();
					return PR.getRanking();
				}
			}else if(c3.getValue() == c4.getValue()) {
				PR = PokerRanking.TwoPair;
				//MaxPlayableValue
				this.maxPlayableValue = c3.getValue();
				return PR.getRanking();

			}
		}
		
		//Pair
		if(c1.getValue()!= c2.getValue()){
			if(c2.getValue()!=c3.getValue()){
				if(c3.getValue()!=c4.getValue()){
					if(c4.getValue()== c5.getValue()) {
						PR = PokerRanking.OnePair;
						//MaxPlayableValue
						this.maxPlayableValue = c5.getValue();	
						return PR.getRanking();
					}
				}else if(c3.getValue()==c4.getValue()) {
					PR = PokerRanking.OnePair;
					//MaxPlayableValue
					this.maxPlayableValue = c4.getValue();
					return PR.getRanking();
				}
			}else if(c2.getValue()== c3.getValue()) {
				PR = PokerRanking.OnePair;
				//MaxPlayableValue
				this.maxPlayableValue = c3.getValue();
				return PR.getRanking();
			}
		}else if(c1.getValue()== c2.getValue()) {
			PR = PokerRanking.OnePair;
			//MaxPlayableValue
			this.maxPlayableValue = c2.getValue();
			return PR.getRanking();
		}
		
		

		return PR.getRanking(); // Return the int value of the enum 
		
	}

	@Override           
	public void play() { // Do to abstract method implemented in Player, Play is a needed function although it is not used, it is used by subclass of PokerPlayer
		// TODO Auto-generated method stub
		
	}
	

	
}
