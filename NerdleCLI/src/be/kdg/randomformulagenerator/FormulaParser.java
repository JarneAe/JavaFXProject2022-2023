package be.kdg.randomformulagenerator;

import java.util.ArrayList;
import java.util.List;
import org.mariuszgromada.math.mxparser.*;

public class FormulaParser {

    private static int sizeConstraint = 8;

    public static void setSizeConstraint(int size_constraint) {
        FormulaParser.sizeConstraint = size_constraint;
    }

    /**
     *
     * @param formula the formula in an array of strings WITHOUT A RESULT!
     * @return result of the formula
     */
    public static double getResult(List<String> formula) {
        StringBuilder expressionBuilder = new StringBuilder();
        for (String character : formula) {
            expressionBuilder.append(character);
        }

        String expressionString = expressionBuilder.toString();

        Expression e = new Expression(expressionString);

        return e.calculate();
    }

    /**
     *
     * @param input the input from user in a list
     * @return true if the input passes all checks (has a result, result matches expression, expression contains operators)
     * and false if it does not
     */
    public static void validateExpressionWithResult(List<String> input) throws Exception {
        if (!input.contains("=")) {
            throw new IllegalArgumentException("No result found");
        }

        if (!input.contains("+") && !input.contains("-") && !input.contains("*") && !input.contains("/")) {
            throw new IllegalArgumentException("No operators found");
        }

        if (input.size() != sizeConstraint) {
            throw new IllegalArgumentException("Not the right size");
        }


        int isEqualToIndex = input.indexOf("=");

        if (isEqualToIndex+1 >= input.size()) { // if "=" is the last character of the input, thus not having a valid result
            throw new IllegalArgumentException("No result found");
        }

        ArrayList<String> expression = new ArrayList<>(input.subList(0, isEqualToIndex)); // ArrayList of everything before the "=" (the mathematical expression)
        String resultString = String.join("", input.subList(isEqualToIndex+1, input.size())); // String of everything after the "=" (the result)

        if (Integer.parseInt(resultString) < 0) { // negative number
            throw new IllegalArgumentException("Negative result found");
        }

        if (Integer.parseInt(resultString) != FormulaParser.getResult(expression)) {
            throw new IllegalArgumentException("Result does not match expression");
        }
        // returns true if the result in input matches the result of the expression
        // should also catch decimal number results
    }

    /**
     * @param expression ArrayList of an expression without a result
     */
    public static void appendResultToExpression(ArrayList<String> expression) {

        try {
            validateExpressionWithResult(expression);
        } catch (Exception e) {
            System.out.println("expression already complete");
        }

        String resultOfExpression = Integer.toString((int) FormulaParser.getResult(expression));
        expression.add("=");
        for (int i = 0; i < resultOfExpression.length(); i++) {
            expression.add(String.valueOf((resultOfExpression.charAt(i))));
        }
    }

    public static boolean validateGeneratorOutput(ArrayList<String> generatorOutput) {
        appendResultToExpression(generatorOutput);

        try {
            validateExpressionWithResult(generatorOutput);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public static void main(String[] args) {
//        ArrayList<String> test1 = new ArrayList<String>(Arrays.asList("5", "+", "3", "/", "3", "+", "3", "3", "-", "5", "6", "/", "2")); // 11
//        ArrayList<String> test2 = new ArrayList<String>(Arrays.asList("5", "*", "3", "+", "2", "2", "-", "8", "+", "7", "6", "5", "4", "3", "-", "2", "5", "/", "5")); // 76567
//        ArrayList<String> test3 = new ArrayList<String>(Arrays.asList("5", "*", "5", "*", "5")); // 125
//        ArrayList<String> test4 = new ArrayList<String>(Arrays.asList("2", "1", "6", "/", "3")); // 72
//        ArrayList<String> test5 = new ArrayList<String>(Arrays.asList("2", "2", "-", "2", "3")); // -1
//
//        ArrayList<String> test1withResult = new ArrayList<String>(Arrays.asList("5", "+", "3", "/", "3", "+", "3", "3", "-", "5", "6", "/", "2", "=", "11")); // 11
//        ArrayList<String> test2withResult = new ArrayList<String>(Arrays.asList("5", "*", "3", "+", "2", "2", "-", "8", "+", "7", "6", "5", "4", "3", "-", "2", "5", "/", "5", "=", "76567")); // 76567
//        ArrayList<String> test3withResult = new ArrayList<String>(Arrays.asList("5", "*", "5", "*", "5", "=", "125"));
//        ArrayList<String> test4withResult = new ArrayList<String>(Arrays.asList("5", "*", "5", "*", "5", "="));
//
//        System.out.println();
//
//        System.out.println(FormulaParser.getResult(test1));
//        System.out.println(FormulaParser.getResult(test2));
//        System.out.println(FormulaParser.getResult(test3));
//
//        System.out.println(FormulaParser.validateExpressionWithResult(test1withResult));
//        System.out.println(FormulaParser.validateExpressionWithResult(test2withResult));
//        System.out.println(FormulaParser.validateExpressionWithResult(test3withResult));
//        System.out.println(FormulaParser.validateExpressionWithResult(test4withResult));
//
//        System.out.println(FormulaParser.appendResultToExpression(test1));
//        System.out.println(FormulaParser.appendResultToExpression(test2));
//       System.out.println(FormulaParser.appendResultToExpression(test3));
//
//        System.out.println(validateGeneratorOutput(test4));
//        System.out.println(validateGeneratorOutput(test3));
//        System.out.println(validateGeneratorOutput(test5));
//
//        System.out.println(test4);
//        System.out.println(test5);
    } // testing, ignore
}
