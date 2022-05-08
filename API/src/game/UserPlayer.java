package game;

public class UserPlayer extends Player{
    
    
	public UserPlayer() {
	}
	@Override
	public void drawCard(){
		this.p_hand.add(BlackJackGame.pack.getPack().get(0));
		BlackJackGame.pack.getPack().remove(0);
	}
	@Override

	public void putCardInTrashPile(){

	}
	@Override
	public void passTurn(){
		
	}
	@Override
	public Boolean play() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
