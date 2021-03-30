package carTrip;
//created by J.M.

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CarTest {

    private static final String MODEL = "testModel";
    private static final double TANK_CAPACITY = 10.20;
    private static final double FUEL_AMOUNT = 5.50;
    private static final double FUEL_CONSUMPTION_PER_KM = 1.10;
    private static Car car;

    @Before
    public void setUp() {

        car = new Car(MODEL, TANK_CAPACITY, FUEL_AMOUNT, FUEL_CONSUMPTION_PER_KM);
    }

    @Test
    public void testConstructorShouldSetAllParameters() {

        assertEquals(MODEL, car.getModel());
        assertEquals(TANK_CAPACITY, car.getTankCapacity(), 0.00);
        assertEquals(FUEL_AMOUNT, car.getFuelAmount(), 0.00);
        assertEquals(FUEL_CONSUMPTION_PER_KM, car.getFuelConsumptionPerKm(), 0.00);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorMustFailsWhenParametersIsNotCorrect(){

        car = new Car("",0.0,0.0,0.0);
    }

    @Test
    public void testSetModelMustSetCorrectModelWhenDataIsValid() {

        String testModel = "BMW";
        car.setModel(testModel);
        assertEquals(testModel, car.getModel());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetModelMustFailsWhenModelIsInvalidData() {

        String testModel = "";
        car.setModel(testModel);
    }

    @Test
    public void testSetTankCapacityMustSetCorrectValue() {

        double testDouble = 100.10;
        car.setTankCapacity(testDouble);
        assertEquals(testDouble, car.getTankCapacity(), 0.00);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetFuelAmountMustFailsWhenGetInvalidData() {

        double testDouble = 100.10;
        car.setFuelAmount(testDouble);
    }

    @Test
    public void testSetFuelAmountMustSetCorrectWhenDataIsValid() {

        double testDouble = 4.40;
        car.setFuelAmount(testDouble);
        assertEquals(testDouble, car.getFuelAmount(), 0.00);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetFuelConsumptionPerKmMustFailsWhenGetInvalidData() {

        double testDouble = 0.00;
        car.setFuelConsumptionPerKm(testDouble);
    }

    @Test
    public void testSetFuelConsumptionPerKmMustSetCorrectWhenDataIsValid() {

        double testDouble = 2.00;
        car.setFuelConsumptionPerKm(testDouble);
        assertEquals(testDouble, car.getFuelConsumptionPerKm(), 0.00);
    }

    @Test(expected = IllegalStateException.class)
    public void testDriveMustFailsWhenNotHaveEnoughFuel() {

        double testDouble = car.getFuelConsumptionPerKm() * 100.00;
        car.drive(testDouble);
    }

    @Test
    public void testDriveMustReturnCorrectMessageWhenDrive() {

        double testDouble = 1.00;
        double expected = car.getFuelAmount()-testDouble*car.getFuelConsumptionPerKm();
        String message = "Have a nice trip";
        assertEquals(message,car.drive(testDouble));
        assertEquals(expected,car.getFuelAmount(),0.00);
    }

    @Test(expected = IllegalStateException.class)
    public void testRefuelMustFailsWhenNotEnoughTankCapacity(){

        double testDouble = 1000.00;
        car.refuel(testDouble);
    }
    @Test
    public void testRefuelMustSetCorrectAmountFuelIfEnoughTankCapacity(){

        double testDouble = 1.00;
        double amountBefore = car.getFuelAmount();
        double expected = testDouble + amountBefore;
        car.refuel(testDouble);
        assertEquals(expected,car.getFuelAmount(),0.00);
    }
}