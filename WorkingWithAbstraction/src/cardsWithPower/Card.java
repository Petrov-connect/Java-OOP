package cardsWithPower;
//created by J.M.

public class Card {

    private final Ranks rank;
    private final Suits suit;
    private final int power;

    public Card(Ranks rank, Suits suit) {
        this.rank = rank;
        this.suit = suit;
        this.power = rank.getRankPower()+suit.getSuitPower();
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d",this.rank,this.suit,this.power);
    }
}


