package game;


/**
 * PokerRanking is an enum used to representate the Poker Plays and adds an int value in order to compare 
 * them as a Value Rank. The most valuable is represented with a 10
 * and the least valuable is represented with a 1 
 * @author Jennifer Hernandez,Gabriel Olvera
 */
public enum PokerRanking {
    RoyalFlush(10), // Having King, Queen, Jack, 10 and Ace of the same suit
    StraightFlush(9), // Having a consecutive order of cards of the same suit 
    FourOfAKind(8), // Having Four Cards that are equal in value but different suit 
    FullHouse(7), // Having One Pair and a ThreeOfAKind
    Flush(6), // Having every single card of same suit 
    Straight(5), // Having a sequence of cards but different suit 
    ThreeOfAKind(4), //Having ThreeCards of Same Value, different suit 
    TwoPair(3), // Having two Pairs different value between each other
    OnePair(2), // Having two Cars of same Value
    HighCard(1); // Default , having a card that has highValue 
    
    private int ranking; // Atribute of enum that adds an int value to each instance of enum 
    
    /**
     * Private Constructor 
     * @param ranking
     */
    private PokerRanking(int ranking) { 
        this.ranking=ranking;
    }
    /**
     * Function that returns the int value of the PokerRanking Instance 
     * @return ranking
     */
    public int getRanking() { 
        return this.ranking;
    } 
    
    /**
     * Override toString that prints the name of the enum Instance  
     */
    @Override
    public String toString() {
    	return this.name();
    }
    
}
