package core.factories;
//created by J.M.

import core.commands.*;
import core.commands.boatCommands.*;
import core.commands.interfaces.Command;
import core.commands.raceCommands.GetStatistic;
import core.commands.raceCommands.OpenRace;
import core.commands.raceCommands.SignUpBoat;
import core.commands.raceCommands.StartRace;
import core.factories.interfaces.BoatFactory;
import core.factories.interfaces.CommandFactory;
import core.factories.interfaces.EngineFactory;
import models.boats.Boat;
import models.engines.Engine;
import core.controllers.interfaces.RaceManager;
import repository.Repository;

public class CommandWorkshop implements CommandFactory {
    private final EngineFactory engineFactory;
    private final BoatFactory boatFactory;
    private final Repository<Engine> engineRepository;
    private final Repository<Boat> boatRepository;
    private final RaceManager raceManager;

    public CommandWorkshop(EngineFactory engineFactory, BoatFactory boatFactory,
                           Repository<Engine> engineRepository, Repository<Boat> boatRepository,
                           RaceManager raceManager) {
        this.engineFactory = engineFactory;
        this.boatFactory = boatFactory;
        this.engineRepository = engineRepository;
        this.boatRepository = boatRepository;
        this.raceManager = raceManager;
    }

    @Override
    public Command produce(String type) {
        Command command = null;

        switch (type) {
            case "CreateBoatEngine":
                command = new CreateBoatEngine(this.engineRepository, this.engineFactory);
                break;
            case "CreateRowBoat":
                command = new CreateRowBoat(this.boatRepository, this.boatFactory);
                break;
            case "CreateSailBoat":
                command = new CreateSailBoat(this.boatRepository, this.boatFactory);
                break;
            case "CreatePowerBoat":
                command = new CreatePowerBoat(this.boatRepository, this.boatFactory);
                break;
            case "CreateYacht":
                command = new CreateYacht(this.boatRepository, this.boatFactory);
                break;
            case "OpenRace":
                command = new OpenRace(this.raceManager);
                break;
            case "SignUpBoat":
                command = new SignUpBoat(this.raceManager, this.boatRepository);
                break;
            case "StartRace":
                command = new StartRace(this.raceManager);
                break;
            case "GetStatistic":
                command = new GetStatistic(this.raceManager);
                break;
            case "End":
                command = new End();
                break;
        }

        return command;
    }
}
