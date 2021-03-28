package core.commands.boatCommands;
//created by J.M.

import core.factories.interfaces.BoatFactory;
import models.boats.Boat;
import repository.Repository;

public class CreateSailBoat extends BoatCommand {
    public CreateSailBoat(Repository<Boat> boatRepository, BoatFactory boatFactory) {
        super(boatRepository, boatFactory);
    }
}
