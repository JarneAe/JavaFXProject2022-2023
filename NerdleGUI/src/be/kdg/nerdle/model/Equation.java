package be.kdg.nerdle.model;

import be.kdg.nerdle.model.randomformulagenerator.FormulaParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// IntelliJ told me this should be a record, so it's a record.
public record Equation(String value) {
    public Equation(String value) {
        try {
            validate(value);
            this.value = value;
        } catch (IllegalArgumentException e) {
            System.out.println("equation rejected.");
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        try {
            return String.join("", value);
        } catch (NullPointerException npe) {
            // should theoretically never happen, since value is checked in the constructor?
            return "Equation has no valid value.";
        }
    }

    private void validate(String equation) {
        List<String> equationAsList = new ArrayList<>(Arrays.asList(equation.split("")));
        FormulaParser.validateExpressionWithResult(equationAsList);
    }
}
