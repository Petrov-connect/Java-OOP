package bakery.repositories.interfaces;

import bakery.entities.drinks.interfaces.Drink;

import java.util.ArrayList;
import java.util.Collection;

public class DrinkRepositoryImpl implements DrinkRepository<Drink> {
    private Collection<Drink> models;

    public DrinkRepositoryImpl() {
        this.models = new ArrayList<>();
    }


    @Override
    public Drink getByNameAndBrand(String drinkName, String drinkBrand) {
        return null;
    }

    @Override
    public Collection<Drink> getAll() {
        return null;
    }

    @Override
    public void add(Drink drink) {

    }
}
