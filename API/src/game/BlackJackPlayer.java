package game;

/**
 * Class that Extends Player and represents all the subclasses of player that know how to play BlackJack
 * @author Jennifer Hernandez,Gabriel Olvera
 */
public abstract class BlackJackPlayer extends Player {
	
	/**
	 * Public Constructor 
	 */
	public BlackJackPlayer(){
	}

	/**
	 * sum Of Hand is equal in all BlackJack Players 
	 */
	@Override
	public int sumOfHand(){ 
		int value=0;
		boolean as= false;
		
		for ( int i = 0; i < p_hand.size(); i++ ) {
			int cardValue = p_hand.get(i).value;
			if (cardValue > 10) {
				cardValue = 10;
			}
			if (cardValue == 1) {
				as = true;
			}
			value +=cardValue;
		}

		/* Ace is always equal to 1, except that if it changes to 11, the result is less or 21 it changes. */
		if ( as == true && value + 10 <= 21 )
			value = value + 10;
		return value;
	}
	
	
	

	
}
