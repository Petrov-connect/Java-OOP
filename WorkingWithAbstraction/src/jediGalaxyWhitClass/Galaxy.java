package jediGalaxyWhitClass;
//created by J.M.

import java.util.*;

public class Galaxy {

    public static int[][] matrix;
    public static long playerPoints = 0;

    public static void createGalaxy(String input) {
        int[] size = readArray(input);
        matrix = new int[size[0]][size[1]];
        int value = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = value++;
            }
        }
    }

    public static void playerStartMove(String input) {
        int[] index = readArray(input);
        int row = index[0];
        int col = index[1];
        while (row >= 0 && col < matrix[0].length) {
            if (row < matrix.length && col >= 0) {
                playerPoints += matrix[row][col];
            }
            row--;
            col++;
        }
    }

    public static void evilStartMove(String input) {
        int[] index = readArray(input);
        int row = index[0];
        int col = index[1];
        while (row >= 0 && col >= 0) {
            if (row < matrix.length && col < matrix[row].length) {
                matrix[row][col] = 0;
            }
            row--;
            col--;
        }
    }

    public static int[] readArray(String input) {
        return Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
}
