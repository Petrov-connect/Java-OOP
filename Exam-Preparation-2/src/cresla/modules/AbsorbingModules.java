package cresla.modules;
//created by J.M.

import cresla.interfaces.AbsorbingModule;

public abstract class AbsorbingModules extends Modules implements AbsorbingModule {

    private final int heatAbsorbing;


    protected AbsorbingModules(int id, int heatAbsorbing) {
        super(id);
        this.heatAbsorbing = heatAbsorbing;
    }

    @Override
    public String getParameter() {
        return "Heat Absorbing";
    }

    @Override
    public int getHeatAbsorbing() {
        return this.heatAbsorbing;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("%s Module – %d", this.getClass().getSimpleName(), this.getId()));
        output.append(System.lineSeparator()).append(String.format("%s: %d", this.getParameter(), getHeatAbsorbing()));
        return output.toString();
    }
}
