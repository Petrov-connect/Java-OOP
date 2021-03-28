package core.commands.raceCommands;
//created by J.M.

import manager.exceptions.InsufficientContestantsException;
import manager.exceptions.NoSetRaceException;
import core.controllers.interfaces.RaceManager;

public class StartRace extends RaceCommand {
    public StartRace(RaceManager raceController) {
        super(raceController);
    }

    @Override
    public String execute(String[] args) {
        String message;
        try {
            this.getRaceController().startRace();
            message = this.getRaceController().getRaceResult();
        } catch (InsufficientContestantsException | NoSetRaceException e) {
           message = e.getMessage();
        }

        return message;
    }
}
