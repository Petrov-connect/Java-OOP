package models.boats;
//created by J.M.

import manager.exceptions.ArgumentException;
import models.engines.Engine;
import models.Race;

public class PowerBoat extends Boat {
    private final Engine primaryEngine;
    private final Engine secondaryEngine;

    public PowerBoat(String model, int weight, Engine primaryEngine,
                     Engine secondaryEngine) throws ArgumentException {
        super(model, weight);
        this.primaryEngine = primaryEngine;
        this.secondaryEngine = secondaryEngine;
    }

    @Override
    public double calcSpeed(Race race) {
        return (this.primaryEngine.getOutput()
                + this.secondaryEngine.getOutput()) - this.getWeight()
                + (race.getCurrentSpeed() / 5.00);
    }
}
