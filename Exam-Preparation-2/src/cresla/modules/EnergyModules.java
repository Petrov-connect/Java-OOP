package cresla.modules;
//created by J.M.

import cresla.interfaces.EnergyModule;

public abstract class EnergyModules extends Modules implements EnergyModule {

    private final int energyOutput;


    protected EnergyModules(int id, int energyOutput) {
        super(id);
        this.energyOutput = energyOutput;
    }

    @Override
    public String getParameter() {
        return "Energy Output";
    }

    @Override
    public int getEnergyOutput() {
        return this.energyOutput;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("%s Module – %d", this.getClass().getSimpleName(), this.getId()));
        output.append(System.lineSeparator()).append(String.format("%s: %d", this.getParameter(), getEnergyOutput()));
        return output.toString();
    }
}
