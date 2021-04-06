package garage;
//created by J.M.

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class GarageTests {

    private static final String brand1 = "bmw";
    private static final String brand2 = "audi";
    private static final int maxSpeed1 = 250;
    private static final int maxSpeed2 = 210;
    private static final double price1 = 2000;
    private static final double price2 = 1000;

    Car car1;
    Car car2;
    Garage garage;

    @Before
    public void setUp() {

        garage = new Garage();
        car1 = new Car(brand1, maxSpeed1, price1);
        car2 = new Car(brand2, maxSpeed2, price2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCarMustFailsWhenObjectIsNull() {
        garage.addCar(null);
    }

    @Test
    public void testAddCarShouldAddCorrect() {
        garage.addCar(car1);
        garage.addCar(car2);
        List<Car>cars=garage.getCars();
        Assert.assertEquals(2,garage.getCount());
        Assert.assertEquals(brand1,cars.get(0).getBrand());
        Assert.assertEquals(maxSpeed1,cars.get(0).getMaxSpeed());
        Assert.assertEquals(price1,cars.get(0).getPrice(),0.0);
    }

    @Test
    public void testFindAllCarsByBrandShouldReturnsAllCarsBYGivenBrand() {
        garage.addCar(car1);
        garage.addCar(car2);
        garage.addCar(car2);
        List<Car>cars=garage.findAllCarsByBrand("audi");
        Assert.assertEquals(brand2,cars.get(0).getBrand());
        Assert.assertEquals(brand2,cars.get(1).getBrand());
        List<Car>cars1=garage.findAllCarsByBrand("abv");
        Assert.assertTrue(cars1.isEmpty());
    }

    @Test
    public void testGetTheMostExpensiveCarShouldReturnsCorrespondingCar() {
        garage.addCar(car2);
        garage.addCar(car1);
        Assert.assertEquals(price1,garage.getTheMostExpensiveCar().getPrice(),0.0);
    }

    @Test
    public void testFindAllCarsWithMaxSpeedAboveShouldReturnsAllCorrespondingCars() {
        garage.addCar(car1);
        garage.addCar(car2);
        garage.addCar(car2);
        List<Car>cars=garage.findAllCarsWithMaxSpeedAbove(210);
        Assert.assertEquals(car1,cars.get(0));
        List<Car>cars1=garage.findAllCarsWithMaxSpeedAbove(300);
        Assert.assertTrue(cars1.isEmpty());

    }

}