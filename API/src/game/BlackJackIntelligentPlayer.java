package game;

/**
 * Subclass of BlackPlayer that emulates the playstile of an Intelligent Player of Type BlackJackPlayer 
 * @author Jennifer Hernandez,Gabriel Olvera
 */
public class BlackJackIntelligentPlayer extends BlackJackPlayer {
	
	/**
	 * Public Constructor
	 */
	public BlackJackIntelligentPlayer(){  

	}
	
	/**
	 * Function of Play that also evaluates probabilities depending on Sum of hands if it's convinient to keep grabbing 
	 */
	@Override
	public void play() {
		System.out.printf("\n\n----------------- Player %s -----------------",this.name);
		
		while (!handReady) {//While player is not finished with it's turn 
			System.out.printf("\nHand: %d\n",this.sumOfHand());
			System.out.println(this.getP_hand());
			int getRandomValue = (int) (Math.random()*(100-1)) + 1;
		
			if (this.sumOfHand()==21) {//If the sum of Player is 21 he wins
				System.out.printf("%s tiene BlackJack",this.name);
				this.handReady = true;
				this.turn++;
				break;
			}

			if (this.sumOfHand()>21) {//If the sum is more than 21 he losses 
				System.out.printf("Tiene más de 21, %s pierde ",this.name);
				this.handReady=true;
				this.turn++;
				break;
			}

			//
			
			//Probabilities of grabbing card depending in sum of hand 
			if(this.sumOfHand()<=11) drawCard();
			if(this.sumOfHand()==12){
				if (getRandomValue<=90) {
					drawCard();
				}else{
					passTurn();
					break;
				}
			}
			if(this.sumOfHand()==13 || this.sumOfHand()==14){ // sum of hand between 13 and 14 
				if (getRandomValue<=70) {
					drawCard();
				}else{
					passTurn();
					break;
				}
			}
			if(this.sumOfHand()==15 || this.sumOfHand()==16){ // sum of hand betwwen 15 and 16
				if (getRandomValue<=60) {
					drawCard();
				}else{
					passTurn();
					break;
				}
			}
			if(this.sumOfHand()>=17 && this.sumOfHand()<=18){ // sum of hand between 17 and 18 
				if (getRandomValue<=20) {
					drawCard();
				}else{
					passTurn();
					break;
				}
			}
			if(this.sumOfHand()>=19 && this.sumOfHand()<=20){ // sum of hand between 19 and 20 
				if (getRandomValue<=5) {
					drawCard();
				}else{
					passTurn(); // else passes turn 
					break;
				}
			}
		}
	}
}
