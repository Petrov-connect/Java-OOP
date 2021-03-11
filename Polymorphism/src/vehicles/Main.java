package vehicles;
//created by J.M.

import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        IntStream.range(0, 2).mapToObj(i -> scan.nextLine().split("\\s+")).forEach(VehicleFactory::create);
        IntStream.range(0, Integer.parseInt(scan.nextLine())).mapToObj(i -> scan.nextLine().split("\\s+"))
                .forEach(VehicleFunctionality::execute);
        VehicleFactory.getInfo().forEach((key, value) -> System.out.println(value.toString()));
    }
}

