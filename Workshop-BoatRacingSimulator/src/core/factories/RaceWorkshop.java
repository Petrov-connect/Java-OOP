package core.factories;
//created by J.M.

import core.factories.interfaces.RaceFactory;
import manager.exceptions.ArgumentException;
import models.Race;

public class RaceWorkshop implements RaceFactory {
    @Override
    public Race produce(String[] args) throws ArgumentException {
        return new Race(Integer.parseInt(args[1]),
                                    Integer.parseInt(args[2]),
                                    Integer.parseInt(args[3]),
                                    Boolean.parseBoolean(args[4]));
    }
}
