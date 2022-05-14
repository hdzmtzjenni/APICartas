package game;


public class StuplidPlayer extends BlackJackPlayer{

	@Override
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
			
			//Hay un 80% de probabilidad de que el jugador agarre una carta
			if (getRandomValue<=80) {//si el número aleatorio es igual o menos a 80, agarra una carta
				drawCard();
			}else{
				passTurn();
				break;
			}
			
		}
		
	}

    
}
