package be.kdg.nerdle.model;

import be.kdg.nerdle.utility.FormulaParser;

import java.util.List;

public class Equation {
    private List<String> value;

    public Equation(List<String> value) {
        try {
            validate(value);
            this.value = value;
        } catch (IllegalArgumentException e) {
            System.out.println("equation rejected.");
        }
    }

    public static void setSizeConstraint(int sizeConstraint) {
        FormulaParser.setSizeConstraint(sizeConstraint);
    }

    public List<String> getValue() {
        return value;
    }

    @Override
    public String toString() {
        try {
            return String.join("", value);
        } catch (NullPointerException npe) {
            return "Equation has no valid value.";
        }
    }

    private void validate(List<String> equation) {
        FormulaParser.validateExpressionWithResult(equation);
    }
}
