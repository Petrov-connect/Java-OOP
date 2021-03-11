package wildFarm;
//created by J.M.

public abstract class Food {

    protected Integer quantity;

    public Food( int quantity) {

        this.quantity = quantity;
    }

    public
    Integer getQuantity () {
        return quantity;
    }
}
