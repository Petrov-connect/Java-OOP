package hell.entities.miscellaneous;

import hell.interfaces.Item;

public class CommonItem implements Item {
    public CommonItem(String name, int strengthBonus, int agilityBonus, int intelligenceBonus, int hitPointsBonus, int damageBonus) {
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getStrengthBonus() {
        return 0;
    }

    @Override
    public int getAgilityBonus() {
        return 0;
    }

    @Override
    public int getIntelligenceBonus() {
        return 0;
    }

    @Override
    public int getHitPointsBonus() {
        return 0;
    }

    @Override
    public int getDamageBonus() {
        return 0;
    }
}
