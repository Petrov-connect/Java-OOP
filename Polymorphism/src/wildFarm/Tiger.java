package wildFarm;
//created by J.M.

public class Tiger extends Felime{


    public Tiger(String animalType, String animalName, double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }

    @Override
    public String makeSound() {
        return "ROAAR!!!";
    }

    @Override
    protected void eat(Food food) throws Exception {
        if(!(food instanceof Meat)){
            throw new Exception("Tigers are not eating that type of food!");
        }
        super.eat(food);
    }
}
