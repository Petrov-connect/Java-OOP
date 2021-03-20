package enterNumbers;
//created by J.M.

import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

    public static boolean proceed = true;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String message = "Enter valid Integers in range 1 < start < end < 100";
        System.out.println(message);

        while(proceed){
            try {
                int start = Integer.parseInt(scan.nextLine());
                int end = Integer.parseInt(scan.nextLine());
                printNumbers(start,end);
            }catch (NumberFormatException exception){
                System.out.println(message);
            }
        }
    }

    public static void printNumbers(int start, int end) {
        if (!(start < end) || !(start > 1) || !(end < 100)) {
            throw new NumberFormatException();
        }
        IntStream.rangeClosed(start, end).forEach(System.out::println);
        proceed = false;
    }
}
