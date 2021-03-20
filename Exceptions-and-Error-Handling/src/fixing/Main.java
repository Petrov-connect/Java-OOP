package fixing;
//created by J.M.

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String[] weekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

        try {
            for (int i = 0; i <= weekDays.length; i++) {
                System.out.println(weekDays[i]);
            }
        } catch (ArrayIndexOutOfBoundsException ignored) {

        }
        scan.nextLine();
    }
}
