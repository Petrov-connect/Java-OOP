package animals;
//created by J.M.

public class Cat extends Animal{
    protected Cat(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String explainSelf() {
        return String.format("%s%nMEEOW",super.explainSelf());
    }
}
