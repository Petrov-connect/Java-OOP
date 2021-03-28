package cresla.reaktors;
//created by J.M.

import cresla.containers.ModuleContainer;
import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.EnergyModule;
import cresla.interfaces.Reactor;

public abstract class ReactorImpl implements Reactor {

    protected int id;
    protected ModuleContainer moduleContainer;

    protected ReactorImpl(int id, int moduleCapacity) {
        this.id = id;
        this.moduleContainer = new ModuleContainer(moduleCapacity);
    }

    @Override
    public long getTotalEnergyOutput() {
        return 0;
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return 0;
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

    public ModuleContainer getModuleContainer() {
        return moduleContainer;
    }

    @Override
    public String toString() {

        return String.format("%s - %d", this.getClass().getSimpleName(), getId()) +
                System.lineSeparator() + String.format("Energy Output: %d", getTotalEnergyOutput()) +
                System.lineSeparator() + String.format("Heat Absorbing: %d", getTotalHeatAbsorbing()) +
                System.lineSeparator() + String.format("Modules: %d", getModuleCount());
    }
}
