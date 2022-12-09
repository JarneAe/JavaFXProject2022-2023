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

    /**
     *
     * @param input the input from user in an arraylist
     * @return true if the input passes all checks (has a result, result matches expression, expression contains operators)
     * and false if it does not
     */
    public static boolean validateInput(ArrayList<String> input) {
        if (!input.contains("=")) {
            return false; // no result in input
        }

        if (!input.contains("+") && !input.contains("-") && !input.contains("*") && !input.contains("/")) {
            return false; // no operator in input
        }

        ArrayList<String> expression = new ArrayList<>();
        StringBuilder resultString = new StringBuilder();

        for (String character : input) { // get expression without the result
            if (character.equals("=")) {
                break;
            } else {
                expression.add(character);
            }
        }

        int startIndexForResult = input.indexOf("=") + 1;

        if (startIndexForResult >= input.size()) { // if "=" is the last character of the input, thus not having a valid result
            return false;
        }

        for (int i = startIndexForResult; i < input.size(); i++) { // get result from input
            resultString.append(input.get(i));
        }

        return Integer.parseInt(resultString.toString()) == FormulaParser.getResult(expression); // returns true if the result in input matches the result of the expression
    }

    public static void main(String[] args) {
        ArrayList<String> test1 = new ArrayList<String>(Arrays.asList("5", "+", "3", "/", "3", "+", "3", "3", "-", "5", "6", "/", "2")); // 11
        ArrayList<String> test2 = new ArrayList<String>(Arrays.asList("5", "*", "3", "+", "2", "2", "-", "8", "+", "7", "6", "5", "4", "3", "-", "2", "5", "/", "5")); // 76567
        ArrayList<String> test3 = new ArrayList<String>(Arrays.asList("5", "*", "5", "*", "5")); // 125

        ArrayList<String> test1withResult = new ArrayList<String>(Arrays.asList("5", "+", "3", "/", "3", "+", "3", "3", "-", "5", "6", "/", "2", "=", "11")); // 11
        ArrayList<String> test2withResult = new ArrayList<String>(Arrays.asList("5", "*", "3", "+", "2", "2", "-", "8", "+", "7", "6", "5", "4", "3", "-", "2", "5", "/", "5", "=", "76567")); // 76567
        ArrayList<String> test3withResult = new ArrayList<String>(Arrays.asList("5", "*", "5", "*", "5", "=", "125"));
        ArrayList<String> test4withResult = new ArrayList<String>(Arrays.asList("5", "*", "5", "*", "5", "="));

        System.out.println(FormulaParser.getResult(test1));
        System.out.println(FormulaParser.getResult(test2));
        System.out.println(FormulaParser.getResult(test3));

        System.out.println(FormulaParser.validateInput(test1withResult));
        System.out.println(FormulaParser.validateInput(test2withResult));
        System.out.println(FormulaParser.validateInput(test3withResult));
        System.out.println(FormulaParser.validateInput(test4withResult));
    }
}
