package core.commands.raceCommands;
//created by J.M.

import core.commands.interfaces.Command;
import core.controllers.interfaces.RaceManager;

public abstract class RaceCommand implements Command {
    private RaceManager raceController;

    protected RaceCommand(RaceManager raceController) {
        this.raceController = raceController;
    }

    protected RaceManager getRaceController() {
        return this.raceController;
    }
}
