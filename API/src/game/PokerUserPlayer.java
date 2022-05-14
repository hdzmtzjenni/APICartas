package game;

import javax.swing.JOptionPane;

public class PokerUserPlayer extends PokerPlayer{

    public PokerUserPlayer() {
    }

    @Override
	public void play() {
		System.out.printf("\n\n----------------- Player %s -----------------",this.name);

		while (!handReady) {//Mientras el jugador no termine su turno
			//Se muestran las cartas que hay en la mesa
            System.out.println("\nCartas en la mesa");
            System.out.println(PokerGame.getInTable());

			//Se muestran las cartas que el jugador tiene en la mano
            System.out.println("\nHand\n");
			System.out.println(this.getP_hand());
			
			//El jugador decide si cambia una carta de la mesa por una de su mano o si quiere tocar para hacer la última ronda
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
				    action = JOptionPane.showInputDialog("Stand(S) -- Draw a card(D)");
					indexInTable = Integer.parseInt(cardTable);
                }
                String cardHand = JOptionPane.showInputDialog("Card in hand:");
                int indexHand = Integer.parseInt(cardHand);
                if(indexHand>getP_hand().size()){
                    JOptionPane.showMessageDialog(null, "Invalid Option", "Error", JOptionPane.WARNING_MESSAGE);
				    action = JOptionPane.showInputDialog("Stand(S) -- Draw a card(D)");
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
