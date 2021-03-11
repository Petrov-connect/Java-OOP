package vehiclesExtension;
//created by J.M.

public class Car extends VehicleFunctionality {

    private static final double INCREASE_FUEL_PER_KM = 0.9;

    public Car(double fuelQuantity, double fuelConsumption , double tankCapacity) {
        super(fuelQuantity, fuelConsumption + INCREASE_FUEL_PER_KM, tankCapacity);
    }
}
