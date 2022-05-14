package game;

import javax.swing.JOptionPane;

public class BlackJackUserPlayer extends BlackJackPlayer{

	@Override
	public void play() {
		System.out.printf("\n\n----------------- Player %s -----------------",this.name);

		while (!handReady) {//Mientras el jugador no termine su turno
			System.out.printf("\nHand: %d\n",this.sumOfHand());
			System.out.println(this.getP_hand());
		
			if (this.sumOfHand()==21) {//Si la suma de sus cartas es 21 el jugador gana y se acaba su turno
				System.out.printf("%s tiene BlackJack",this.name);
				this.handReady = true;
				this.turn++;
				break;
			}

			if (this.sumOfHand()>21) {//Si la suma es más de 21 el jugador pierde y se acaba su turno
				System.out.printf("Tiene más de 21, %s pierde ",this.name);
				this.handReady=true;
				this.turn++;
				break;
			}
			
			//El jugador decide si agarra otra carta o si se queda y acaba su turno
			String action = JOptionPane.showInputDialog("Stand(S) -- Draw a card(D):");
			action = action.toUpperCase();
			char action1 = action.charAt(0);
			while (action1!= 'D' && action1!='S') {
				JOptionPane.showMessageDialog(null, "Error", "Invalid Option", JOptionPane.WARNING_MESSAGE);
				action = JOptionPane.showInputDialog("Stand(S) -- Draw a card(D)");
			}
			if(action1== 'D')drawCard();
			else if(action1== 'S'){//Si se queda se pasa acaba su turno 
				System.out.printf("%s Stand ",this.name);
				passTurn();
				break;
			} 
		}
	}
}
