package be.kdg.nerdle.model.randomformulagenerator;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * The class GeneratorWithTemplates generates the formulas that streamed to
 * the formules.txt
 *
 * @author Jarne Aerts
 *
 */
public class GeneratorWithTemplates {
    private static final String[] patterns = {"II+II", "I+I+I", "II-II", "I+I-I", "I+I*I", "I*I/I", "I/I+I", "I*I-I", "II*I"};
    private static final List<String> operators = new ArrayList<>(Arrays.asList("+", "-", "/", "+"));
    private static final Random random = new Random();

    /**
     * Generates the array of formulas using the templates.
     * @return return an array of formulas
     */
    private List<String> generate() {

        ArrayList<String> formula = new ArrayList<>();
        String pattern = patterns[random.nextInt(patterns.length)];
        int patternLength = pattern.length();
            for (int i = 0; i < patternLength; i++) {

                int num = (random.nextInt(9));
                if (String.valueOf(pattern.charAt(i)).equals("I")) {
                    //removes weird 0s from formula like a 0 after an operator or at the first index
                    try {
                        if ((num == 0 && operators.contains(String.valueOf(pattern.charAt(i - 1)))) || i == 0) {
                            num = random.nextInt(1, 9);
                        }
                        pattern = pattern.replaceFirst(String.valueOf((pattern.charAt(i))), String.valueOf(num));
                    } catch (StringIndexOutOfBoundsException ignore) {
                    }
                }
            }
        try {
            for (int i = 0; i < patterns.length - 3; i++) {
                formula.add(String.valueOf(pattern.charAt(i)));
            }
        } catch (StringIndexOutOfBoundsException ignore) {
        }
        if (!FormulaParser.validateGeneratorOutput(formula)) {
            formula.clear();
        }
        return formula;
    }

    /**
     * Writes the formulas 1 by 1 to the file.
     * @param array receives the array generated by the generate(): method
     */

    private void WriteToFile(List<List<String>> array) {
        // Tries overwriting a file and throws an error if not possible
        try {
            FileWriter myWriter = new FileWriter("formulas.txt");
            //loops through the array writing every line to the file
            for (List<String> strings : array) {

                String output = String.valueOf(strings);
                //removes the [] , and whitespace from the Strings
                output = output.replaceAll("[\\[\\]]|,\\s*", "");
                myWriter.write(output + "\n");

            }
            // closes the file
            myWriter.close();
            System.out.println("Successfully wrote to the file.");

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Combines all above methods and does additional checks
     * @param amount receives the amount of formulas to be generated
     */
    public void GenerateFormulas(int amount) {

        List<List<String>> formulaArray = new ArrayList<>();
        boolean filled = false;
        int counter = 0;

        while (!filled) {

            List<String> generatedFormula = generate();

            if (!generatedFormula.isEmpty()) {
                formulaArray.add(generatedFormula);
                counter++;
            }

            if (counter == amount) filled = true;
        }
        WriteToFile(formulaArray);
    }
}