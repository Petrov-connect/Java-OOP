package onlineShop.models.products.components;
//created by J.M.

import onlineShop.models.BaseProduct;

public abstract class BaseComponent extends BaseProduct {

    private int generation;

    protected BaseComponent(int id,
                         String manufacturer,
                         String model,
                         double price,
                         double overallPerformance,
                         int generation) {

        super(id, manufacturer, model, price, overallPerformance);

        this.generation = generation;
    }

    public int getGeneration() {
        return generation;
    }

    @Override
    public String toString() {

        return super.toString() + String.format(" Generation: %d", this.generation);
    }
}
