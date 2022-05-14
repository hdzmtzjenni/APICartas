package game;

public enum PokerRanking {
    RoyalFlush(10),
    StraightFlush(9),
    FourOfAKind(8),
    FullHouse(7),
    Flush(6),
    Straight(5),
    ThreeOfAKind(4),
    TwoPair(3),
    OnePair(2),
    HighCard(1);
    
    private int ranking;
    
    private PokerRanking(int ranking) {
        this.ranking=ranking;
    }
    public int getRanking() {
        return this.ranking;
    } 
    
    public String toString() {
    	return this.name();
    }
    
}
