package studentSystem;
//created by J.M.

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        StudentSystem studentSystem = new StudentSystem();
        String input;

        while (!"Exit".equals(input = scan.nextLine())) {
            String[] command = input.split("\\s+");
            String output = studentSystem.parseCommand(command);
            if(output!=null) {
                System.out.println(output);
            }
        }
    }
}
