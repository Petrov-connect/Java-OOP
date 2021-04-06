package easterRaces.entities.drivers;
//created by J.M.

import easterRaces.entities.interfaces.Car;
import easterRaces.entities.interfaces.Driver;

import static easterRaces.common.ExceptionMessages.CAR_INVALID;

public class DriverImpl implements Driver {
    private String name;
    private Car car;
    private int numberOfWins;
    private  boolean canParticipate;

    public DriverImpl(String name) {
        this.setName(name);
        this.canParticipate = false;
    }

    public void setName(String name) {
        if(name == null || name.trim().isEmpty() || name.length()<5){
            throw new IllegalArgumentException(String.format("Name %s cannot be less than 5 symbols.",name));
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Car getCar() {
        return this.car;
    }

    @Override
    public int getNumberOfWins() {
        return this.numberOfWins;
    }

    @Override
    public void addCar(Car car) {
           if (car == null){
               throw new IllegalArgumentException(CAR_INVALID);
           }
           this.car = car;
    }

    @Override
    public void winRace() {
        this.numberOfWins++;

    }

    @Override
    public boolean getCanParticipate() {
        return this.car != null;
    }
}
