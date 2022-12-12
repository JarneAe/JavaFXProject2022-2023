import java.util.ArrayList;
import java.util.Random;

public class Generator {
    private static final String[] OPERATORS = {"+", "-", "*", "/"};

    ArrayList<ArrayList<String>> formulaArray = new ArrayList<>();

    public ArrayList<String> generate() {
        StringBuilder formula = new StringBuilder();
        Random random = new Random();
        ArrayList<String> returnFormula = new ArrayList<>();

        // Generate a random number of digits to use in the formula
        int numDigits = random.nextInt(4) + 1;

        // Generate the specified number of digits and append them to the formula
        for (int i = 0; i < numDigits; i++) {
            // Choose a random digit and append it to the formula
            formula.append(random.nextInt(10));

            // If there is room for another digit, decide whether to use 1 or 2 digits
            if (formula.length() + 2 <= 5) {
                if (random.nextBoolean()) {
                    formula.append(random.nextInt(10));
                }
            }
            // If there is room for an operator, choose a random operator and append it to the formula
            if (formula.length() + 2 <= 5) {
                formula.append(OPERATORS[random.nextInt(OPERATORS.length)]);
            }
        }
        if (formula.toString().length() != 5) {
            System.out.println("formula is too long or too short "+ formula);
            //TODO: use parser to validate output
        } else{
            System.out.println(formula);
            for (int i = 0; i < formula.length(); i++) {
                returnFormula.set(i,(String.valueOf(formula.charAt(i))));
            }
        }
        return returnFormula;
    }

    public ArrayList<ArrayList<String>> GenerateFormulas(int amount){
        for (int i = 0; i < amount; i++) {

            formulaArray.add(generate());
        }
        return formulaArray;
    }

}



