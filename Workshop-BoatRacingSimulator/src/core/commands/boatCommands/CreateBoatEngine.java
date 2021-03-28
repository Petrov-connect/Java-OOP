package core.commands.boatCommands;
//created by J.M.

import core.factories.interfaces.EngineFactory;
import core.commands.interfaces.Command;
import manager.exceptions.ArgumentException;
import manager.exceptions.DuplicateModelException;
import models.engines.Engine;
import repository.Repository;

public class CreateBoatEngine implements Command {
    private final Repository<Engine> engineRepository;
    private final EngineFactory engineFactory;

    public CreateBoatEngine(Repository<Engine> engineRepository, EngineFactory engineFactory) {
        this.engineRepository = engineRepository;
        this.engineFactory = engineFactory;
    }

    @Override
    public String execute(String[] args) {
        String result;
        try {
            this.engineRepository.add(this.engineFactory.produce(args));
            result = String.format("Engine model %s with %s HP and displacement %s cm3 created successfully.", args[1], args[2], args[3]);
        } catch (ArgumentException | DuplicateModelException ex) {
            result = ex.getMessage();
        }
        return result;
    }
}
