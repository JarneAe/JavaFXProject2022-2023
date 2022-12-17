import java.util.ArrayList;
import java.util.List;
import org.mariuszgromada.math.mxparser.*;

public class Equation {
    private List<String> value;
    private static int sizeConstraint;

    public Equation(List<String> value) {
        if (Equation.validate(value)) {
            this.value = value;
        } else {
            System.out.println("equation rejected.");
        }
    }

    @Override
    public String toString() {
        try {
            return String.join("", value);
        } catch (NullPointerException npe) {
            return "Equation has no valid value.";
        }
    }

    public static void setSizeConstraint(int sizeConstraint) {
        Equation.sizeConstraint = sizeConstraint;
    }

    private static boolean validate(List<String> equation) {
        if (!equation.contains("=")) {
            return false; // no result in input
        }

        if (!equation.contains("+") && !equation.contains("-") && !equation.contains("*") && !equation.contains("/")) {
            return false; // no operator in input
        }

        if (equation.size() != sizeConstraint) {
            return false; // wrong size
        }


        int isEqualToIndex = equation.indexOf("=");

        if (isEqualToIndex+1 >= equation.size()) { // if "=" is the last character of the input, thus not having a valid result
            return false;
        }

        ArrayList<String> expression = new ArrayList<>(equation.subList(0, isEqualToIndex)); // ArrayList of everything before the "=" (the mathematical expression)
        String resultString = String.join("", equation.subList(isEqualToIndex+1, equation.size())); // String of everything after the "=" (the result)

        if (Integer.parseInt(resultString) < 0) { // negative number
            return false;
        }

        return Integer.parseInt(resultString) == Equation.getResult(expression); // returns true if the result in input matches the result of the expression
        // should also catch decimal number results
    }

    public static double getResult(List<String> formula) {
        StringBuilder expressionBuilder = new StringBuilder();
        for (String character : formula) {
            expressionBuilder.append(character);
        }

        String expressionString = expressionBuilder.toString();

        Expression e = new Expression(expressionString);

        return e.calculate();
    }
}
