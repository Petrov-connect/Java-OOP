package hell.entities.items;

import hell.interfaces.Recipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class RecipeItem extends Items implements Recipe {

    Collection<CommonItem> requiredItems;

    public RecipeItem(String name,
                      int strengthBonus,
                      int agilityBonus,
                      int intelligenceBonus,
                      int hitPointsBonus,
                      int damageBonus,
                      CommonItem...requiredItems) {
        super(name, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus);
        this.requiredItems = Arrays.asList(requiredItems);
    }

    @Override
    public List<String> getRequiredItems() {
        return null;
    }
}
