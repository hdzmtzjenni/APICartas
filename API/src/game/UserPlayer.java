package game;

import javax.swing.JOptionPane;

public class UserPlayer extends Player{
    
    
	public UserPlayer() {
	}
	

	@Override
	public Boolean play() {
	
		while (!handReady) {
			System.out.printf("\nPlayer %s",this.name);
			System.out.printf("\nHand: %d\n",this.sumOfHand());
			System.out.println(this.getP_hand());
		
			if (this.sumOfHand()==21) {
				System.out.printf("%s tiene BlackJack",this.name);
				this.handReady = true;
				this.turn++;
				break;
			}

			if (this.sumOfHand()>21) {
				System.out.printf("Tiene más de 21, %s pierde",this.name);
				this.handReady=true;
				this.turn++;
				return false;
			}
			
			String action = JOptionPane.showInputDialog("Stand(S) -- Draw a card(D):");
			action = action.toUpperCase();
			char action1 = action.charAt(0);
			while (action1!= 'D' && action1!='S') {
				System.out.println("Invalid Option");
				action = JOptionPane.showInputDialog("Stand(S) -- Draw a card(D)");
			}
			if(action1== 'D')drawCard();
			else if(action1== 'S'){
				System.out.printf("%s Stand",this.name);
				passTurn();
				break;
			} 

			
		}
	
		return true;
	}

	
}
