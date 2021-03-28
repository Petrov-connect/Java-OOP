package cresla.reaktors;
//created by J.M.

public class CryoReactor extends ReactorImpl {

    private final int cryoProductionIndex;


    public CryoReactor(int id, int moduleCapacity, int cryoProductionIndex) {
        super(id, moduleCapacity);
        this.cryoProductionIndex = cryoProductionIndex;
    }

    public int getCryoProductionIndex() {

        return cryoProductionIndex;
    }
    @Override
    public long getTotalEnergyOutput() {
        long energyOutput = this.moduleContainer.getTotalEnergyOutput()*getCryoProductionIndex();
        if(energyOutput>this.moduleContainer.getTotalHeatAbsorbing()){
            energyOutput = 0;
        }
        return energyOutput;
    }
}


