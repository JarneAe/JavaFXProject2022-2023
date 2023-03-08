package be.kdg.nerdle.model.randomformulagenerator;

import org.mariuszgromada.math.mxparser.Expression;

import java.util.ArrayList;
import java.util.List;

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
     */
    public static void validateExpressionWithResult(List<String> input) throws IllegalArgumentException {
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
        } catch (IllegalArgumentException ignored) {} // if the method is called when a result is already present

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
}