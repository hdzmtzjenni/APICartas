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
				while (!Character.isDigit(cardTable.charAt(0))) {
					try {
						NumberFormatException(cardTable);
					} catch (NumberException e) {
						System.out.println(e);
						cardTable = JOptionPane.showInputDialog("Card in table:");
					}
				}
		
				int indexInTable = Integer.parseInt(cardTable);
			
				indexInTable =tryCardInTable(cardTable, indexInTable);
				// Ask for the card to swap in the hand 
				String cardHand = JOptionPane.showInputDialog("Card in Hand:");
				while (!Character.isDigit(cardHand.charAt(0))) {
					try {
						NumberFormatException(cardHand);
					} catch (NumberException e) {
						System.out.println(e);
						cardHand = JOptionPane.showInputDialog("Card in table:");
					}
				}
		
				int indexInHand = Integer.parseInt(cardHand);
				indexInHand=tryCardInHand(cardHand, indexInHand);
				

                PokerGame.swapCards(indexInTable, indexInHand, getP_hand());
                this.turn++;
                break;
            }
			else if(action1== 'H'){//if the choice is H, the turn ends 
				System.out.printf("%s Stand ",this.name);
				passTurn();
				break;
			} 
		}
	}

	public void OutOfBoundsException(String card, int index) throws IndexOutException{
		if(index>PokerGame.getInTable().size() ||index>getP_hand().size()){
			throw new IndexOutException(index);
		}
	}

	public void NumberFormatException(String card) throws NumberException{
		if (!Character.isDigit(card.charAt(0))) {
			throw new NumberException(card.charAt(0));
		}
	}

	public int tryCardInTable(String card, int index){
		
		while(index>PokerGame.getInTable().size()  ){
			try {
				OutOfBoundsException(card, index);
			} catch (IndexOutException e) {
				System.out.println(e);;
				card = JOptionPane.showInputDialog("Card in table:");
			} 

			while (!Character.isDigit(card.charAt(0))) {
				try {
					NumberFormatException(card);
				} catch (NumberException e) {
					System.out.println(e);
					card = JOptionPane.showInputDialog("Card in table:");
				}
			}

			index = Integer.parseInt(card);
		}
		return index;
	}

	public int tryCardInHand(String card, int index){
		while(index>this.getP_hand().size()  ){
			try {
				OutOfBoundsException(card, index);
			} catch (IndexOutException e) {
				System.out.println(e);
				card = JOptionPane.showInputDialog("Card in Hand:");
			} 

			while (!Character.isDigit(card.charAt(0))) {
				try {
					NumberFormatException(card);
				} catch (NumberException e) {
					System.out.println(e);
					card = JOptionPane.showInputDialog("Card in Hand:");
				}
			}

			index = Integer.parseInt(card);
		}
		return index;
	}

}
