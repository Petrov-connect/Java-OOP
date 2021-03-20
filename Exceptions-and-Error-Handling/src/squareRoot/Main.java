package squareRoot;
//created by J.M.

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        try {
            System.out.println(Math.sqrt(Integer.parseInt(scan.nextLine())));

        } catch (NumberFormatException exception) {

            System.out.println("Invalid input");

        } finally {

            System.out.println("Good bye");
        }
    }
}

