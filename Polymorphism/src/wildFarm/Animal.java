package wildFarm;
//created by J.M.

public abstract class Animal {

    protected String animalType;
    protected String animalName;
    protected Double animalWeight;
    protected Integer foodEaten;


    protected Animal(String animalType, String animalName, double animalWeight) {
        this.animalType = animalType;
        this.animalName = animalName;
        this.animalWeight = animalWeight;
        this.foodEaten = 0;
    }

    protected
    void eat (Food food) throws Exception {
        this.foodEaten += food.getQuantity();
    }

    protected abstract String makeSound();

    public String getAnimalType() {
        return animalType;
    }

    public String getAnimalName() {
        return animalName;
    }

    public double getAnimalWeight() {
        return animalWeight;
    }

    public int getFoodEaten() {
        return foodEaten;
    }

}
