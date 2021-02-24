package RhombusOfStars;
//created by J.M.

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        printRhombus(Integer.parseInt(scan.nextLine()));

    }

    static void printRhombus(int n) {
        printHalfRhombus(n, n, true);
        printHalfRhombus(n, n - 1, false);
    }
    private static void printHalfRhombus(int n, int end, boolean isTop) {
        for (int i = 1; i <= end; i++) {
            int spacesEnd = isTop ? n - i : i;
            int starsEnd = isTop ? i : n - i;
            printRow(spacesEnd, " ");
            printRow(starsEnd, "* ");
            System.out.println();
        }
    }
    static void printRow(int end, String symbol) {
        for (int j = 1; j <= end; j++) {
            System.out.print(symbol);
        }
    }
}
