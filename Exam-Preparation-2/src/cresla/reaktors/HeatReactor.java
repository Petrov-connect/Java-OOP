package cresla.reaktors;
//created by J.M.

public class HeatReactor extends ReactorImpl {

    private final int heatReductionIndex;


    public HeatReactor(int id, int moduleCapacity, int heatReductionIndex) {
        super(id, moduleCapacity);
        this.heatReductionIndex = heatReductionIndex;
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return this.moduleContainer.getTotalHeatAbsorbing() + getHeatReductionIndex();
    }

    public int getHeatReductionIndex() {
        return heatReductionIndex;
    }

}
