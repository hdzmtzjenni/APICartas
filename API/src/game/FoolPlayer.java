package game;


// FoolPlayer is a subclass of BlackJackPlayer designed to emulate the playstyle of a BlackJackPlayer that every turn has a 80% chance of drawing another card
// not mattering how close he is to 21. 

public class FoolPlayer extends BlackJackPlayer{

	@Override
	public void play() { // Override of the play function that everytype of BlackJackPlayer has.
		System.out.printf("\n\n----------------- Player %s -----------------",this.name); 
		

		while (!handReady) {//While Player is not done with his turn 
			System.out.printf("\nHand: %d\n",this.sumOfHand());
			System.out.println(this.getP_hand());
			int getRandomValue = (int) (Math.random()*(100-1)) + 1; // Get Random Number 
		
			if (this.sumOfHand()==21) {//If the sum of his Hand is equal to 21, he wins. 
				System.out.printf("%s tiene BlackJack",this.name);
				this.handReady = true;
				this.turn++;
				break;
			}

			if (this.sumOfHand()>21) {// If the sum of his Hand is greater than 21, he loses. 
				System.out.printf("Tiene más de 21, %s pierde ",this.name);
				this.handReady=true;
				this.turn++;
				break;
			}
			
			//Comparation with random number to generate the 80%chance decision 
			if (getRandomValue<=80) {// If number is within range he draws a card, else he passes turn. 
				drawCard();
			}else{
				passTurn();
				break;
			}
			
		}
		
	}

    
}
