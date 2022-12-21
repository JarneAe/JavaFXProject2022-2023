package be.kdg.nerdle;

import java.util.List;
import be.kdg.randomformulagenerator.FormulaParser;

public class Equation {
    private List<String> value;

    public Equation(List<String> value) {
        try {
            validate(value);
            this.value = value;
        } catch (Exception e) {
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

    private void validate(List<String> equation) throws Exception {
        FormulaParser.validateExpressionWithResult(equation);
    }
}
