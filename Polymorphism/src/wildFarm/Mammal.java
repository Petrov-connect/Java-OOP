package wildFarm;
//created by J.M.

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {

    protected String livingRegion;

    protected Mammal(String animalType, String animalName, double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight);
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion() {
        return livingRegion;
    }

    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat("##.##");
        return String.format("%s[%s, %s, %s, %d]", this.getAnimalType(),
                this.getAnimalName(), format.format(this.getAnimalWeight()),
                this.getLivingRegion(), this.getFoodEaten());
    }
}
