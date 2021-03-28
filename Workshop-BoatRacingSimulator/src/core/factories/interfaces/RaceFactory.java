package core.factories.interfaces;
//created by J.M.

import manager.exceptions.ArgumentException;
import models.Race;

public interface RaceFactory {
    Race produce(String[] args) throws ArgumentException;
}
