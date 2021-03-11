package wildFarm;
//created by J.M.

import java.text.DecimalFormat;

public class Cat extends Felime {

    private final String breed;

    public Cat(String animalType, String animalName, double animalWeight, String livingRegion, String breed) {
        super(animalType, animalName, animalWeight, livingRegion);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public String makeSound() {
        return "Meowwww";
    }

    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat("##.##");
        return String.format("%s[%s, %s, %s, %s, %d]", this.getClass().getSimpleName()
                , this.getAnimalName(), this.getBreed()
                , format.format(this.getAnimalWeight()), this.getLivingRegion(), this.getFoodEaten());
    }
}
