package validPerson;
//created by J.M.

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String firstName = scan.nextLine();
        String lastName = scan.nextLine();
        int age = Integer.parseInt(scan.nextLine());

        try {
            Person person = new Person(firstName, lastName, age);
        } catch (IllegalArgumentException exception) {
            System.out.println("Exception thrown: " + exception.getMessage());
        }
    }
}
