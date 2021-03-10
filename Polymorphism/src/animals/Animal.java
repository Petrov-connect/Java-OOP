package animals;
//created by J.M.

public abstract class Animal {

    private final String name;
    private final String favouriteFood;

    protected Animal(String name, String favouriteFood) {
        this.name = name;
        this.favouriteFood = favouriteFood;
    }

    private String getName() {
        return name;
    }

    private String getFavouriteFood() {
        return favouriteFood;
    }

    public String explainSelf() {
        return String.format("I am %s and my favourite food is %s",getName(),getFavouriteFood());
    }
}
