package trafficLights;
//created by J.M.

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String[] trafficLights = scan.nextLine().split("\\s+");
        int n = Integer.parseInt(scan.nextLine());
        while (n-- >0) {
            StringBuilder output = new StringBuilder();
            for (int i = 0; i < trafficLights.length; i++) {
                trafficLights[i] = String.valueOf(TrafficState.update(TrafficState.valueOf(trafficLights[i])));
                output.append(trafficLights[i]).append(" ");
            }
            System.out.println(output.toString().trim());
        }
    }
}
