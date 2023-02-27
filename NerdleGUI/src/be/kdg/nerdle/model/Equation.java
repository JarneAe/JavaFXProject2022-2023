package be.kdg.nerdle.model;

import be.kdg.nerdle.model.randomformulagenerator.FormulaParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Equation {
    private String value;

    public Equation(String value) {
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

    public String  getValue() {
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

    private void validate(String equation) {
        List<String> equationAsList = new ArrayList<>(Arrays.asList(equation.split("")));
        FormulaParser.validateExpressionWithResult(equationAsList);
    }
}
