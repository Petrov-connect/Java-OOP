package onlineShop.models.products.computers;
//created by J.M.

public class Laptop extends BaseComputer{

    private static double overallPerformance = 10;

    public Laptop(int id, String manufacturer, String model, double price) {
        super(id, manufacturer, model, price, overallPerformance);
    }
}
