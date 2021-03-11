package wildFarm;
//created by J.M.

import java.util.*;

public abstract class Functionality {

    public static List<Animal> animalsInfo = new ArrayList<>();

    public static void execute(String[] animalInfo, String[] food) {

        Animal animal = null;
        String animalType = animalInfo[0];
        String animalName = animalInfo[1];
        double animalWeight = Double.parseDouble(animalInfo[2]);
        String livingRegion = animalInfo[3];
        int foodQuantity = Integer.parseInt(food[1]);

        Food foodType = createFood(food);

        switch (animalType) {
            case "Cat":
                String catBreed = animalInfo[4];
                animal = new Cat(animalType, animalName, animalWeight, livingRegion, catBreed);
                break;
            case "Tiger":
                animal = new Tiger(animalType, animalName, animalWeight, livingRegion);
                break;
            case "Zebra":
                animal = new Zebra(animalType, animalName, animalWeight, livingRegion);
                break;
            case "Mouse":
                animal = new Mouse(animalType, animalName, animalWeight, livingRegion);
                break;
        }

        animalsInfo.add(animal);
        System.out.println(animal.makeSound());

        try {
            animal.eat(foodType);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static List<Animal> getAnimalsInfo() {
        return animalsInfo;
    }

    private static Food createFood(String[] food) {
        String foodType = food[0];
        int foodQuantity = Integer.parseInt(food[1]);

        return foodType.equals("Meat") ? new Meat(foodQuantity) : new Vegetable(foodQuantity);
    }
}
