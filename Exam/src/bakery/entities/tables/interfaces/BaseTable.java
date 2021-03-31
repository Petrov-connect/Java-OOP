package bakery.entities.tables.interfaces;

import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.interfaces.Drink;

import java.util.ArrayList;
import java.util.Collection;

import static bakery.common.ExceptionMessages.*;

public abstract class BaseTable implements Table{


    private int tableNumber;
    private int capacity;
    private double pricePerPerson;

    private boolean isReserved;
    private int numberOfPeople;
    private double price;

    private  Collection<BakedFood>foodOrders;
    private  Collection<Drink>	drinkOrders;

    protected BaseTable(int tableNumber, int capacity, double pricePerPerson) {
        this.tableNumber = tableNumber;
        this.setCapacity(capacity);
        this.pricePerPerson = pricePerPerson;
        this.foodOrders = new ArrayList<>();
        this.drinkOrders = new ArrayList<>();
    }

    private void setCapacity(int capacity) {
        if (capacity <= 0){
            throw new IllegalArgumentException(INVALID_TABLE_CAPACITY);
        }
        this.capacity = capacity;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople < 0){
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public int getTableNumber() {
        return this.tableNumber;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public int getNumberOfPeople() {
        return this.numberOfPeople;
    }

    @Override
    public double getPricePerPerson() {
        return this.pricePerPerson;
    }

    @Override
    public boolean isReserved() {
        return numberOfPeople > 0;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void reserve(int numberOfPeople) {
        this.setNumberOfPeople(numberOfPeople);
        this.price = this.getPricePerPerson() * numberOfPeople;
        this.isReserved = true;
    }

    @Override
    public void orderFood(BakedFood food) {
        this.foodOrders.add(food);
    }

    @Override
    public void orderDrink(Drink drink) {
        this.drinkOrders.add(drink);
    }

    @Override
    public double getBill() {
        double priceAllDrinks = this.drinkOrders.stream().mapToDouble(Drink::getPrice).sum();
        double priceAllFood = this.foodOrders.stream().mapToDouble(BakedFood::getPrice).sum();
        return priceAllDrinks + priceAllFood + this.getPrice();
    }

    @Override
    public void clear() {
        this.foodOrders.clear();
        this.drinkOrders.clear();
        this.isReserved = false;
        this.setNumberOfPeople(0);
        this.price = 0;
    }

    @Override
    public String getFreeTableInfo() {
        String sb = String.format("Table: %d", this.getTableNumber()) +
                System.lineSeparator() +
                String.format("Type: %s", this.getClass().getSimpleName()) +
                System.lineSeparator() +
                String.format("Capacity: %d", this.getCapacity()) +
                System.lineSeparator() +
                String.format("Price per Person: %.2f",
                        this.getPricePerPerson()) +
                System.lineSeparator();
        return sb.trim();
    }
}
