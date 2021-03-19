package harvestingFields;
//created by J.M.

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String input;

        while (!"HARVEST".equals(input = scan.nextLine())) {
            String modifier = input;
            Arrays.stream(RichSoilLand.class.getDeclaredFields()).filter(field ->
                    Modifier.toString(field.getModifiers()).equals(modifier) || modifier.equals("all"))
                    .forEach(f -> System.out.printf("%s %s %s%n"
                            , Modifier.toString(f.getModifiers()), f.getType().getSimpleName(), f.getName()));

        }
    }
}
