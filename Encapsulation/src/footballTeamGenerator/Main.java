package footballTeamGenerator;
//created by J.M.

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Map<String, Team> teams = new HashMap<>();
        String input;

        while (!"END".equals(input = scan.nextLine())) {

            String[] command = input.trim().split(";");
            String name = command[1];

            switch (command[0]) {
                case "Team":
                    try {
                        Team team = new Team(name);
                        teams.putIfAbsent(command[1], team);
                    } catch (Exception exception) {
                        System.out.println(exception.getMessage());
                    }
                    break;
                case "Add":
                    if (!teams.containsKey(name)) {
                        System.out.printf("Team %s does not exist.%n", command[1]);
                    } else {
                        try {
                            teams.get(name).addPlayer(new Player(command[2]
                                    , Integer.parseInt(command[3]), Integer.parseInt(command[4])
                                    , Integer.parseInt(command[5]), Integer.parseInt(command[6])
                                    , Integer.parseInt(command[7])));
                        } catch (Exception exception) {
                            System.out.println(exception.getMessage());
                        }
                    }
                    break;
                case "Remove":
                    try {
                        teams.get(name).removePlayer(command[2]);
                    } catch (Exception exception) {
                        System.out.println(exception.getMessage());
                    }
                    break;
                case "Rating":
                    if (!teams.containsKey(name)) {
                        System.out.printf("Team %s does not exist.%n", name);
                    } else {
                        System.out.printf("%s - %.0f%n", name, (teams.get(name).getRating()));
                    }
                    break;
            }
        }
    }
}
