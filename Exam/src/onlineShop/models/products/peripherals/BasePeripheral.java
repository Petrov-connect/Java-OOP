package onlineShop.models.products.peripherals;
//created by J.M.

import onlineShop.models.BaseProduct;

public abstract class BasePeripheral extends BaseProduct {

    private String connectionType;

    protected BasePeripheral(int id,
                          String manufacturer,
                          String model,
                          double price,
                          double overallPerformance,
                          String connectionType) {

        super(id, manufacturer, model, price, overallPerformance);

        this.connectionType = connectionType;
    }

    public String getConnectionType() {
        return connectionType;
    }

    @Override
    public String toString() {

        return super.toString() + String.format(" Connection Type: %s", this.connectionType);
    }
}
