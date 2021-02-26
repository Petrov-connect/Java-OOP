package cardRank;
//created by J.M.

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println(scan.nextLine()+":");
        for (Ranks value : Ranks.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n",value.ordinal(),value.name());
        }
    }
}
