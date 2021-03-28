package core.commands.boatCommands;
//created by J.M.

import core.factories.interfaces.BoatFactory;
import core.commands.interfaces.Command;
import manager.exceptions.ArgumentException;
import manager.exceptions.DuplicateModelException;
import manager.exceptions.NonExistantModelException;
import models.boats.Boat;
import repository.Repository;

public abstract class BoatCommand implements Command {
    private final Repository<Boat> boatRepository;
    private final BoatFactory boatFactory;

    protected BoatCommand(Repository<Boat> boatRepository, BoatFactory boatFactory) {
        this.boatRepository = boatRepository;
        this.boatFactory = boatFactory;
    }

    @Override
    public String execute(String[] args) {
        String message;
        try {
            Boat boat = this.boatFactory.produce(args);
            if (boat != null) {
                boatRepository.add(boat);
                message = String.format("%s with model %s registered successfully.",
                        this.getClass().getSimpleName().replace("Create", "").replace("Boat", " boat"), args[1]);
            } else {
                throw new NonExistantModelException("Invalid boat model!");
            }
        } catch (ArgumentException | DuplicateModelException | NonExistantModelException e) {
            message = e.getMessage();
        }
        return message;
    }
}
