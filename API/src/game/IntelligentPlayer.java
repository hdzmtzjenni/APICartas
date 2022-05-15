package game;


public class IntelligentPlayer extends BlackJackPlayer {
	
	public IntelligentPlayer(){

	}
	
	// Funcion que juega a Black Jack y determina si vale la pena seguir jugando o no dependiendo de sus cartas actuales 
	public void play() {
		System.out.printf("\n\n----------------- Player %s -----------------",this.name);
		
		while (!handReady) {//Mientras el jugador no termine su turno
			System.out.printf("\nHand: %d\n",this.sumOfHand());
			System.out.println(this.getP_hand());
			int getRandomValue = (int) (Math.random()*(100-1)) + 1;
		
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

			//
			
			//Hay un 80% de probabilidad de que el jugador agarre una carta
			if(this.sumOfHand()<=11) drawCard();
			if(this.sumOfHand()==12){
				if (getRandomValue<=90) {
					drawCard();
				}else{
					passTurn();
					break;
				}
			}
			if(this.sumOfHand()==13 || this.sumOfHand()==14){
				if (getRandomValue<=70) {
					drawCard();
				}else{
					passTurn();
					break;
				}
			}
			if(this.sumOfHand()==15 || this.sumOfHand()==16){
				if (getRandomValue<=60) {
					drawCard();
				}else{
					passTurn();
					break;
				}
			}
			if(this.sumOfHand()>=17 && this.sumOfHand()<=18){
				if (getRandomValue<=20) {
					drawCard();
				}else{
					passTurn();
					break;
				}
			}
			if(this.sumOfHand()>=19 && this.sumOfHand()<=20){
				if (getRandomValue<=5) {
					drawCard();
				}else{
					passTurn();
					break;
				}
			}
			
			
		}
		
		
		
	}

	
	

}
