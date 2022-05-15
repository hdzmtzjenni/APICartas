package game;

import java.util.Collections;

import javax.swing.JOptionPane;

// PokerUserPlayer is a subclass from PokerPlayer that is used to aggregate all the functions needed to play Poker as a User with console Inputs. 

public class PokerUserPlayer extends PokerPlayer{

    public PokerUserPlayer() { // Constructor
    }

    @Override
	public void play() { // Override of the play function that each of Player Subclass has 
		System.out.printf("\n\n----------------- Player %s -----------------",this.name);

		while (!handReady) {//While turn not finished 
			//The cards inTable are shown in console 
            System.out.println("\nIn Table");
            System.out.println(PokerGame.getInTable());

			//The cards that the player has are printed too
            System.out.println("\nHand\n");
			Collections.sort(this.getP_hand());
			System.out.println(this.getP_hand());
			
			//The User Inputs its decision whether he swaps card or decides that is hand is ready, making it last round for everybody
			String action = JOptionPane.showInputDialog("SwapCards(S) -- HandReady(H):");
			action = action.toUpperCase();
			char action1 = action.charAt(0);

			//Si la respuesta es diferente a H o S vuelve a preguntar hasta que lo ingrese bien
			while (action1!= 'H' && action1!='S' || action.length()>1) {
				JOptionPane.showMessageDialog(null, "Invalid Option", "Error", JOptionPane.WARNING_MESSAGE);
				action = JOptionPane.showInputDialog("SwapCards(S) -- HandReady(H):");
				action = action.toUpperCase();
				action1 = action.charAt(0);
			}

			//Si la respuesta es S, se le pregunta al jugador que carta de la mesa quiere agarrar y cual carta de su mano deja 
			if(action1== 'S'){
                String cardTable = JOptionPane.showInputDialog("Card in table:");
                int indexInTable = Integer.parseInt(cardTable);
                if(indexInTable>PokerGame.getInTable().size()){
                    JOptionPane.showMessageDialog(null, "Invalid Option", "Error", JOptionPane.WARNING_MESSAGE);
				    action = JOptionPane.showInputDialog("Card in table:");
					indexInTable = Integer.parseInt(cardTable);
                }
                String cardHand = JOptionPane.showInputDialog("Card in hand:");
                int indexHand = Integer.parseInt(cardHand);
                if(indexHand>getP_hand().size()){
                    JOptionPane.showMessageDialog(null, "Invalid Option", "Error", JOptionPane.WARNING_MESSAGE);
				    action = JOptionPane.showInputDialog("Card in hand");
					indexHand = Integer.parseInt(cardHand);
                }
                PokerGame.swapCards(indexInTable, indexHand, getP_hand());
                this.turn++;
                break;
            }
			else if(action1== 'H'){//Si se queda se pasa acaba su turno 
				System.out.printf("%s Stand ",this.name);
				passTurn();
				break;
			} 
		}
	}
		
		
	
}
