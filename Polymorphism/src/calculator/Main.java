package calculator;
//created by J.M.

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        CalculationEngine engine = new CalculationEngine();
        InputInterpreter interpreter = Extensions.buildInterpreter(engine);
        String[] tokens = scanner.nextLine().split("\\s+");

        Arrays.stream(tokens).takeWhile(token -> !token.equals("end")).forEach(interpreter::interpret);

        System.out.println(engine.getCurrentResult());
    }
}
