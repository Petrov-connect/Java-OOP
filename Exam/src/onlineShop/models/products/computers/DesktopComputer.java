package onlineShop.models.products.computers;
//created by J.M.

public class DesktopComputer extends BaseComputer{

    private static double overallPerformance = 15;

    public DesktopComputer(int id, String manufacturer, String model, double price) {
        super(id, manufacturer, model, price, overallPerformance);
    }
}
