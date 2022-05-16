package game;

import javax.swing.JOptionPane;

/**
 * Class that extends BlackJackPlayer and uses methods of how to play Black Jack as a User 
 * @author Jennifer Hernandez,Gabriel Olvera
 */
public class BlackJackUserPlayer extends BlackJackPlayer{

	public BlackJackUserPlayer() {
	}

	/**
	 * Override of the play function that everytype of BlackJackPlayer has.
	 */
	@Override
	public void play() {
		System.out.printf("\n\n----------------- Player %s -----------------",this.name);

		while (!handReady) {//while the turn is not ready 
			System.out.printf("\nHand: %d\n",this.sumOfHand());
			System.out.println(this.getP_hand());
		
			if (this.sumOfHand()==21) {// If Sum of Hand is equal to 21 it wins, end turn 
				System.out.printf("%s has BlackJack",this.name);
				this.handReady = true;
				this.turn++;
				break;
			}

			if (this.sumOfHand()>21) {//Si la suma es más de 21 el jugador pierde y se acaba su turno
				System.out.printf("you Have more than 21, %s losses ",this.name);
				this.handReady=true;
				this.turn++;
				break;
			}
			
			//User chooses to Stand or Draw Card 
			String action = JOptionPane.showInputDialog("Stand(S) -- Draw a card(D):");
			action = action.toUpperCase();
			char action1 = action.charAt(0);
			while (action1!= 'D' && action1!='S') {
				JOptionPane.showMessageDialog(null, "Error", "Invalid Option", JOptionPane.WARNING_MESSAGE);
				action = JOptionPane.showInputDialog("Stand(S) -- Draw a card(D)");
			}
			if(action1== 'D')drawCard();
			else if(action1== 'S'){//If it Stands 
				System.out.printf("%s Stand ",this.name);
				passTurn();
				break;
			} 
		}
	}
}
