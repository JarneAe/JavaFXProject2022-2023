import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.mariuszgromada.math.mxparser.*;

public class FormulaParser {

    /**
     *
     * @param formula the formula in an array of strings WITHOUT A RESULT!
     * @return result of the formula
     */
    public static int getResult(ArrayList<String> formula) {
        StringBuilder expressionBuilder = new StringBuilder();
        for (String character : formula) {
            expressionBuilder.append(character);
        }

        String expressionString = expressionBuilder.toString();

        Expression e = new Expression(expressionString);

        return (int) e.calculate();
    }

    public static boolean validateInput(ArrayList<String> input) {
        if (!input.contains("=")) {
            return false; // no result in input
        }

        if (!input.contains("+") && !input.contains("-") && !input.contains("*") && !input.contains("/")) {
            return false; // no operator in input
        }

        StringBuilder expressionString = new StringBuilder();

        for (String character : input) {
            if (character.equals("")) {
                break;
            } else {
                expressionString.append(character);
            }
        }

        return true;
    }

    public static void main(ArrayList<String> args) {
        ArrayList<String> test1 = new ArrayList<String>(Arrays.asList("5", "+", "3", "/", "3", "+", "3", "3", "-", "5", "6", "/", "2")); // 11
        ArrayList<String> test2 = new ArrayList<String>(Arrays.asList("5", "*", "3", "+", "2", "2", "-", "8", "+", "7", "6", "5", "4", "3", "-", "2", "5", "/", "5")); // 76567
        ArrayList<String> test3 = new ArrayList<String>(Arrays.asList("5", "*", "5", "*", "5")); // 125

        ArrayList<String> test1withResult = new ArrayList<String>(Arrays.asList("5", "+", "3", "/", "3", "+", "3", "3", "-", "5", "6", "/", "2", "=", "11")); // 11
        ArrayList<String> test2withResult = new ArrayList<String>(Arrays.asList("5", "*", "3", "+", "2", "2", "-", "8", "+", "7", "6", "5", "4", "3", "-", "2", "5", "/", "5", "=", "125")); // 76567
        ArrayList<String> test3withResult = new ArrayList<String>(Arrays.asList("5", "*", "5", "*", "5", "=", "125"));

        System.out.println(FormulaParser.getResult(test1));
        System.out.println(FormulaParser.getResult(test2));
        System.out.println(FormulaParser.getResult(test3));
    }
}
