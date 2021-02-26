package hotelReservation;
//created by J.M.

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");

        PriceCalculator calculator = new PriceCalculator(
                Double.parseDouble(input[0])
                , Integer.parseInt(input[1])
                , Season.valueOf(input[2].toUpperCase())
                , input[3].equals("SecondVisit") ? DiscountType.SECOND_VISIT : DiscountType.valueOf(input[3].toUpperCase()));

        System.out.printf("%.2f%n", calculator.calculate());
    }
}
