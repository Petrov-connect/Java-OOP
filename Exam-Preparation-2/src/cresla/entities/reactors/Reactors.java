package cresla.entities.reactors;
//created by J.M.

import cresla.entities.containers.ModuleContainer;
import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.EnergyModule;
import cresla.interfaces.Reactor;

public abstract class Reactors implements Reactor {

    private final int id;
    private final ModuleContainer moduleContainer;

    protected Reactors(int id, int moduleCapacity) {
        this.id = id;
        this.moduleContainer = new ModuleContainer(moduleCapacity);
    }

    @Override
    public long getTotalEnergyOutput() {

        long energyOutput = this.moduleContainer.getTotalEnergyOutput();
        if (energyOutput > this.getTotalHeatAbsorbing()) {
            energyOutput = 0;
        }
        return energyOutput;
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return this.moduleContainer.getTotalHeatAbsorbing();
    }

    @Override
    public int getId() {
        return this.id;
    }


    @Override
    public int getModuleCount() {

        return this.moduleContainer.getModuleByInputCount();
    }

    @Override
    public void addEnergyModule(EnergyModule energyModule) {
        this.moduleContainer.addEnergyModule(energyModule);
    }

    @Override
    public void addAbsorbingModule(AbsorbingModule absorbingModule) {
        this.moduleContainer.addAbsorbingModule(absorbingModule);
    }

    @Override
    public String toString() {

        return String.format("%s - %d", this.getClass().getSimpleName(), getId()) +
                System.lineSeparator() +
                String.format("Energy Output: %d", getTotalEnergyOutput()) +
                System.lineSeparator() +
                String.format("Heat Absorbing: %d", getTotalHeatAbsorbing()) +
                System.lineSeparator() +
                String.format("Modules: %d", getModuleCount());
    }
}
