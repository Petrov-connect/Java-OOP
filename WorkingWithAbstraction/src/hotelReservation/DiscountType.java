package hotelReservation;
//created by J.M.

public enum DiscountType {

    VIP(20),
    SECOND_VISIT(10),
    NONE(0);

    private final int percent;

    DiscountType(int percent) {
        this.percent = percent;
    }

    public int getPercent() {
        return percent;
    }
}
