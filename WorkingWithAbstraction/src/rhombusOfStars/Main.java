package rhombusOfStars;
//created by J.M.

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        printRhombus(Integer.parseInt(scan.nextLine()));

    }

    private static void printRhombus(int n) {
        printTriangle(n, true);
        printTriangle(n, false);
    }

    private static void printTriangle(int n, boolean directionUp) {
        for (int i = 1; i <= n; i++) {
            int firstSymbolCount = directionUp ? n - i : i;
            int secondSymbolCount = directionUp ? i : n - i;
            printRow(firstSymbolCount, " ");
            printRow(secondSymbolCount, "* ");
            System.out.println();
        }
    }

    private static void printRow(int count, String symbol) {
        for (int j = 1; j <= count; j++) {
            System.out.print(symbol);
        }
    }
}
