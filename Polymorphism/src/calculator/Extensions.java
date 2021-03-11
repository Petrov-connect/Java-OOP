package calculator;
//created by J.M.

public class Extensions {

    public static InputInterpreter buildInterpreter(CalculationEngine engine) {

        return new InputInterpreter(engine);
    }
}
