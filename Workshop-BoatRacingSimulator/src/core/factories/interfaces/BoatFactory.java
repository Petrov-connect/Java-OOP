package core.factories.interfaces;
//created by J.M.

import manager.exceptions.ArgumentException;
import manager.exceptions.NonExistantModelException;
import models.boats.Boat;

public interface BoatFactory {
    Boat produce(String[] args) throws ArgumentException, NonExistantModelException;
}
