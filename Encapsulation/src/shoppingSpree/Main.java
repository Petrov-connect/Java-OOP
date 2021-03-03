package shoppingSpree;
//created by J.M.

import java.util.*;

public class Main {

    private static final Map<String, Person> people = new LinkedHashMap<>();
    private static final Map<String, Product> products = new LinkedHashMap<>();

    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        try {
            setObject(scan, "Person");
            setObject(scan, "Product");
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return;
        }
        String command;

        while (!"END".equals(command = scan.nextLine())) {
            try {
                String[] tokens = command.split("\\s+");
                people.get(tokens[0]).buyProduct(products.get(tokens[1]));
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }

        people.values().forEach(System.out::println);
    }

    private static void setObject(Scanner scanner, String clazz) {
        String[] inputData = scanner.nextLine().split(";");
        Arrays.stream(inputData).map(s -> s.split("=")).forEach(data -> {
            var object = clazz.equals("Person")
                    ? people.put(data[0].trim(), new Person(data[0].trim(), Double.parseDouble(data[1].trim())))
                    : products.put(data[0].trim(), new Product(data[0].trim(), Double.parseDouble(data[1].trim())));
        });
    }
}
