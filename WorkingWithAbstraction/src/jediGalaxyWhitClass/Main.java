package jediGalaxyWhitClass;
//created by J.M.

import java.util.*;

public class Main extends Galaxy{

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        createGalaxy(scan.nextLine());
        String command;

        while (!"Let the Force be with you".equals(command = scan.nextLine())) {
            evilStartMove(scan.nextLine());
            playerStartMove(command);
        }
        System.out.println(playerPoints);

    }
}
