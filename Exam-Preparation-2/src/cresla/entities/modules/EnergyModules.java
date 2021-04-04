package cresla.entities.modules;
//created by J.M.

import cresla.interfaces.EnergyModule;

public abstract class EnergyModules  extends Modules implements EnergyModule {

    private final int energyOutput;

    protected EnergyModules(int id, int energyOutput) {
        super(id);
        this.energyOutput = energyOutput;
    }

    @Override
    public int getEnergyOutput() {
        return this.energyOutput;
    }


    @Override
    public String toString() {

        return String.format("%s Module – %d%nEnergy Output: %d",
                this.getClass().getSimpleName(),
                this.getId(),
                this.getEnergyOutput());

    }
}
