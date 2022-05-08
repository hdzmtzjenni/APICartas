package game;


public class IntelligentPlayer extends BlackJackPlayer {
	
	

	public IntelligentPlayer(){

	}
	
	@Override
	public void drawCard() {
		

	}

	@Override
	public void passTurn() {
		// TODO Auto-generated method stub

	}
	
	// Funcion que juega a Black Jack y determina si vale la pena seguir jugando o no dependiendo de sus cartas actuales 
	
	public void play() {
		
		int cardSumInHand = 0; // que tiene actualmente en la mano determiado por el valor de las cartas. 
		
		
		for(  Card c : this.p_hand) {
			cardSumInHand += c.getNumber();
			
		}
		
		
	}

	@Override
	public void putCardInTrashPile() {
		// TODO Auto-generated method stub
		
	}
	
	

}
