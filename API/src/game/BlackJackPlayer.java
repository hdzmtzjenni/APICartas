package game;


public abstract class BlackJackPlayer extends Player {
	
	public BlackJackPlayer(){
		
	}
	

	public int getBlackJackvalue(){
		int value=0;
		boolean as= false;
		
		for ( int i = 0; i < p_hand.size(); i++ ) {
			int cardValue = p_hand.get(i).number;
			if (cardValue > 10) {
				cardValue = 10;
			}
			if (cardValue == 1) {
				as = true;
			}
			value +=cardValue;
		}

		/* El as vale 1 al principio, pero si al cambiar su valor por 11 el resultado es igual a 21 o menor se cambia*/
		if ( as == true && value + 10 <= 21 )
			value = value + 10;
		return value;
	}

	
}
