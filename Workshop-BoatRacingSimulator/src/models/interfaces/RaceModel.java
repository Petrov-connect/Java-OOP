package models.interfaces;
//created by J.M.

import manager.exceptions.ArgumentException;
import manager.exceptions.DuplicateModelException;
import manager.exceptions.InsufficientContestantsException;
import models.boats.Boat;

import java.util.Set;

public interface RaceModel {

    int getDistance();

    int getCurrentSpeed();

    int getWindSpeed();

    boolean allowsMotorBoats();

    Set<Boat> getParticipants();

    void startRace() throws InsufficientContestantsException;

    void addParticipant(Boat participant) throws DuplicateModelException, ArgumentException;

    String getStatistics();

    String getResult();
}
