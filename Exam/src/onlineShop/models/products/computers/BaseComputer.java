package onlineShop.models.products.computers;
//created by J.M.

import onlineShop.models.BaseProduct;
import onlineShop.models.Product;
import onlineShop.models.products.components.Component;
import onlineShop.models.products.peripherals.Peripheral;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static onlineShop.common.constants.ExceptionMessages.*;

public abstract class BaseComputer extends BaseProduct {

    private List<Component> components;
    private List<Peripheral> peripherals;

    protected BaseComputer(int id,
                        String manufacturer,
                        String model,
                        double price,
                        double overallPerformance) {

        super(id, manufacturer, model, price, overallPerformance);

        this.components = new LinkedList<>();
        this.peripherals = new LinkedList<>();
    }

    public List<Component> getComponents() {
        return components;
    }

    public List<Peripheral> getPeripherals() {
        return peripherals;
    }

    public void addComponent(Component component) {

        Component exist = components.stream().filter(e -> e.getClass().getSimpleName()
                .equals(component.getClass().getSimpleName())).findFirst().orElse(null);
        if (exist != null) {
            throw new IllegalArgumentException(String.format(EXISTING_COMPONENT,
                    exist.getClass().getSimpleName(), this.getClass().getSimpleName(), this.getId()));
        }
        this.components.add(component);
    }

    public Component removeComponent(String componentType) {

        Component exist = components.stream().filter(e -> e.getClass().getSimpleName()
                .equals(componentType)).findFirst().orElse(null);
        if(components.isEmpty() || exist == null){
            throw new IllegalArgumentException(String.format(NOT_EXISTING_COMPONENT,
                    componentType, this.getClass().getSimpleName(), this.getId()));
        }
        components.remove(exist);
        return exist;
    }

    public void addPeripheral(Peripheral peripheral) {

        Peripheral exist = peripherals.stream().filter(e -> e.getClass().getSimpleName()
                .equals(peripheral.getClass().getSimpleName())).findFirst().orElse(null);
        if (exist != null) {
            throw new IllegalArgumentException(String.format(EXISTING_PERIPHERAL,
                    exist.getClass().getSimpleName(), this.getClass().getSimpleName(), this.getId()));
        }
        this.peripherals.add(peripheral);
    }

    public Peripheral removePeripheral(String peripheralType) {

        Peripheral exist = peripherals.stream().filter(e -> e.getClass().getSimpleName()
                .equals(peripheralType)).findFirst().orElse(null);
        if(peripherals.isEmpty() || exist == null){
            throw new IllegalArgumentException(String.format(NOT_EXISTING_COMPONENT,
                    peripheralType, this.getClass().getSimpleName(), this.getId()));
        }
        peripherals.remove(exist);
        return exist;
    }

    @Override
    public double getPrice() {

        return super.getPrice() +
                components.stream().mapToDouble(Product::getPrice).sum() +
                peripherals.stream().mapToDouble(Product::getPrice).sum();
    }

    @Override
    public double getOverallPerformance() {

        if (this.components.isEmpty()) {
            return super.getOverallPerformance();
        } else {
            return getAveragePerformance();
        }
    }

    @Override
    public String toString() {

        StringBuilder out = new StringBuilder(super.toString());

        out.append(System.lineSeparator())
                .append(String.format(" Components (%d):", this.components.size()))
                .append(System.lineSeparator());
        if (!this.components.isEmpty()) {
            out.append(" ")
                    .append(String.format("%s", this.components.stream().map(String::valueOf)
                            .collect(Collectors.joining(" %n"))));
        }
        out.append(String.format(" Peripherals (%d); Average Overall Performance (%f):"
                , this.peripherals.size(), getOverallPerformance()))
                .append(System.lineSeparator());
        if (!this.peripherals.isEmpty()) {
            out.append(" ")
                    .append(String.format("%s", this.peripherals.stream().map(String::valueOf)
                            .collect(Collectors.joining(" %n"))));
        }
        return out.toString().trim();
    }

    private double getAveragePerformance() {

        return this.peripherals.stream().mapToDouble(Product::getOverallPerformance).average().orElse(0);
    }
}
