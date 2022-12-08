    import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FormulaParser {

    private static final ArrayList<String> possibleCharacters = new ArrayList<>(List.of(
            "0","1","2","3","4","5","6","7","8","9","+","-","*","/"
    ));

    /**
     *
     * @param formula the formula, in an array of strings, from formula generator
     * @return the formula split into its numbers and operators, for example [2, 1, 6, /, 3] ->
     * [[216, 3], [/]]
     */
    private ArrayList<ArrayList<String>> splitNumbersAndOperators(String[] formula) {
        ArrayList<String> numbers = new ArrayList<>();
        ArrayList<String> operators = new ArrayList<>();
        StringBuilder tempNumber = new StringBuilder();

        for (int i = 0; i < formula.length; i++) {
            if (possibleCharacters.subList(0, 10).contains(formula[i])) { // if element is a number
                tempNumber.append(formula[i]);

            } else { // if element is an operator
                numbers.add(tempNumber.toString());
                tempNumber.setLength(0); // reset stringbuilder
                operators.add(formula[i]);
            }

            if (i == formula.length - 1 && tempNumber.length() != 0) { // if it has reached the end of the formula and there still is a number
                numbers.add(tempNumber.toString());
            }
        }

        return new ArrayList<>(Arrays.asList(numbers, operators));
    }

    private int eval(ArrayList<ArrayList<String>> splitElements) {
        ArrayList<String> numbers = splitElements.get(0);
        ArrayList<String> operators = splitElements.get(1);

        ArrayList<String> updatedNumbers = new ArrayList<>();
        ArrayList<String> updatedOperators = new ArrayList<>();

        System.out.println(numbers);
        System.out.println(operators);

        for (int i = 0; i < operators.size(); i++) {
            if (operators.get(i).equals("*")) {
                int result = Integer.parseInt(numbers.get(i)) * Integer.parseInt(numbers.get(i+1));
                updatedNumbers.add(String.valueOf(result));
                numbers.set(i+1, "0");

            } else if (operators.get(i).equals("/")) {
                int result = Integer.parseInt(numbers.get(i)) / Integer.parseInt(numbers.get(i+1));
                updatedNumbers.add(String.valueOf(result));
                numbers.set(i+1, "0");

            } else {
                updatedNumbers.add(numbers.get(i));
                updatedOperators.add(operators.get(i));
            }
        }

        updatedNumbers.removeIf(x -> (x .equals("0")));

        System.out.println(updatedNumbers);
        System.out.println(updatedOperators);

        int finalResult = Integer.parseInt(updatedNumbers.get(0));

        for (int i = 0; i < updatedOperators.size(); i++) {
            if (updatedOperators.get(i).equals("+")) {
                finalResult += Integer.parseInt(updatedNumbers.get(i + 1));

            } else if (updatedOperators.get(i).equals("-")) {
                finalResult -= Integer.parseInt(updatedNumbers.get(i + 1));
            }
        }

        return finalResult;
    }

    public static void main(String[] args) {
        String[] test1 = new String[]{"5", "+", "3", "/", "3", "+", "3", "3", "-", "5", "6", "/", "2"}; // 11
        String[] test2 = new String[]{"5", "*", "3", "+", "2", "2", "-", "8", "+", "7", "6", "5", "4", "3", "-", "2", "5", "/", "5"}; // 76567

        FormulaParser parser = new FormulaParser();
        ArrayList<ArrayList<String>> split1 = parser.splitNumbersAndOperators(test1);
        System.out.println(parser.eval(split1));

        ArrayList<ArrayList<String>> split2 = parser.splitNumbersAndOperators(test2);
        System.out.println(parser.eval(split2));

        // TODO: fix multiple division / multiplication


        System.out.println();
    }
}
