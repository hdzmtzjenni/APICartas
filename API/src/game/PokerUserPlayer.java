package game;

import java.util.Collections;

import javax.swing.JOptionPane;

import game.exception.NumberException;

import game.exception.IndexOutException;

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

			//If input is different of 'H' or 'S' it keeps asking until right 
			while (action1!= 'H' && action1!='S' || action.length()>1) {
				JOptionPane.showMessageDialog(null, "Invalid Option", "Error", JOptionPane.WARNING_MESSAGE);
				action = JOptionPane.showInputDialog("SwapCards(S) -- HandReady(H):");
				action = action.toUpperCase();
				action1 = action.charAt(0);
			}

			//if the input is 'S' it is demanded to input the Card Index from table he wants to grab and the Card Index of his own hand that he want to swap for. 
			// Indexes are represented as [1-5] 
			if(action1== 'S'){
                String cardTable = JOptionPane.showInputDialog("Card in table:");
                int indexInTable = Integer.parseInt(cardTable);
                while(indexInTable>PokerGame.getInTable().size()){
					try {
						OutOfBoundsException(cardTable, indexInTable);
					} catch (IndexOutException e) {
						e.printStackTrace();
						cardTable = JOptionPane.showInputDialog("Card in table:");
						indexInTable = Integer.parseInt(cardTable);
					} catch (NumberException e) {
						e.printStackTrace();
						cardTable = JOptionPane.showInputDialog("Card in table:");
						indexInTable = Integer.parseInt(cardTable);
					}
				}

                String cardHand = JOptionPane.showInputDialog("Card in hand:");
                int indexHand = Integer.parseInt(cardHand);
                while (indexHand>getP_hand().size()) {
					try {
						OutOfBoundsException(cardHand, indexHand);
					} catch (IndexOutException e) {
						e.printStackTrace();
						cardHand = JOptionPane.showInputDialog("Card in hand");
						indexHand = Integer.parseInt(cardHand);
					} catch (NumberException e) {
						e.printStackTrace();
						cardHand = JOptionPane.showInputDialog("Card in hand");
						indexHand = Integer.parseInt(cardHand);
					}
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

	public void OutOfBoundsException(String card, int index) throws IndexOutException, NumberException{
		if(index>PokerGame.getInTable().size() ||index>getP_hand().size()){
			throw new IndexOutException(index);
		}
		if (!Character.isDigit(card.charAt(0))) {
			throw new NumberException(card.charAt(0));
		}
	}
		
	
}
