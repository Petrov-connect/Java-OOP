package cardsWithPower;
//created by J.M.

public enum Suits {

    CLUBS (0), DIAMONDS (13), HEARTS (26), SPADES (39);

    private final int suitPower;

    Suits(int suitPower) {
        this.suitPower = suitPower;
    }

    public int getSuitPower() {
        return suitPower;
    }
}
