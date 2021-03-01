package jediGalaxy;
//created by J.M.

import java.util.*;

public class Main {
    private static long playerPoints = 0;
    private static int[][] matrix;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int[] size = readArray(scan.nextLine());
        fillMatrix(size);
        String command;

        while (!"Let the Force be with you".equals(command = scan.nextLine())) {
            int[] playerStartIndex = readArray(command);
            int[] evilStartIndex = readArray(scan.nextLine());
            evilStartMove(evilStartIndex[0], evilStartIndex[1]);
            playerStartMove(playerStartIndex[0], playerStartIndex[1]);
        }
        System.out.println(playerPoints);
    }

    private static void playerStartMove(int row, int col) {
        while (row >= 0 && col < matrix[0].length) {
            if (row < matrix.length && col >= 0) {
                playerPoints += matrix[row][col];
            }
            col++;
            row--;
        }
    }

    private static void evilStartMove(int row, int col) {
        while (row >= 0 && col >= 0) {
            if (row < matrix.length && col < matrix[row].length) {
                matrix[row][col] = 0;
            }
            row--;
            col--;
        }
    }

    private static void fillMatrix(int[] index) {
        matrix = new int[index[0]][index[1]];
        int value = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = value++;
            }
        }
    }

    private static int[] readArray(String input) {
        return Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
}
