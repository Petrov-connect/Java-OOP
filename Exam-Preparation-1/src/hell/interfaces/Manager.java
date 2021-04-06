package hell.interfaces;
//created by J.M.

import java.util.List;

public interface Manager {

    String addHero(List<String> arguments);

    String addItem(List<String> arguments);

    String addRecipe(List<String> arguments);

    String inspect(List<String> arguments);

    String quit();
}
