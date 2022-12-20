package be.kdg.nerdle;

import java.util.List;
import be.kdg.randomformulagenerator.FormulaParser;

public class Equation {
    private List<String> value;
    private boolean validated;

    public Equation(List<String> value) {
        if (validate(value)) {
            this.value = value;
            this.validated = true;
        } else {
            System.out.println("equation rejected.");
            this.value = null;
            this.validated = false;
        }
    }

    public static void setSizeConstraint(int sizeConstraint) {
        FormulaParser.setSizeConstraint(sizeConstraint);
    }

    public boolean isValidated() {
        return validated;
    }

    @Override
    public String toString() {
        try {
            return String.join("", value);
        } catch (NullPointerException npe) {
            return "Equation has no valid value.";
        }
    }

    private boolean validate(List<String> equation) {
        return FormulaParser.validateExpressionWithResult(equation);
    }
}
