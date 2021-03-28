//created by J.M.

import core.commands.CommandHandler;
import core.factories.BoatWorkshop;
import core.factories.CommandWorkshop;
import core.controllers.MainController;
import core.factories.EngineWorkshop;
import core.factories.interfaces.CommandFactory;
import manager.InputManager;
import manager.OutputManager;
import models.boats.Boat;
import models.engines.Engine;
import core.controllers.RaceController;
import repository.Repository;
import repository.RepositoryImpl;

public class Main {
    public static void main(String[] args) {
        Repository<Boat> boatRepository = new RepositoryImpl<>();
        Repository<Engine> engineRepository = new RepositoryImpl<>();
        CommandFactory commandFactory = new CommandWorkshop(
                new EngineWorkshop()
                , new BoatWorkshop(engineRepository)
                , engineRepository, boatRepository
                , new RaceController());
        MainController controller = new MainController(
                new InputManager()
                , new OutputManager()
                , new CommandHandler(commandFactory));
        controller.run();
    }
}
