package HotelReservation;
//created by J.M.

public class PriceCalculator {

    private final double pricePerDay;
    private final int numberOfDays;
    private final Season season;
    private final DiscountType discountType;


    public PriceCalculator(double pricePerDay, int numberOfDays, Season season,DiscountType discountType) {
        this.pricePerDay = pricePerDay;
        this.numberOfDays = numberOfDays;
        this.season = season;
        this.discountType = discountType;

    }

    public double calculate(){
        return pricePerDay*numberOfDays*season.getMultiplier()*(1-(discountType.getPercent()/100.0));
    }
}
