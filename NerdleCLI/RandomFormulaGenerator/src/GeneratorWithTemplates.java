import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

public class GeneratorWithTemplates {
    String[] patterns = {"II+II", "I+I+I", "II-II", "I+I-I", "I+I*I", "I*I/I", "I/I+I", "I*I-I"};
    Random random = new Random();


    private ArrayList<String> generate() {

        ArrayList<String> formula = new ArrayList<>();
        String pattern = patterns[random.nextInt(patterns.length)];
        int patternLength = patterns.length - (patterns.length - 5);


        for (int i = 0; i < patternLength; i++) {

            int num = (random.nextInt(9));

            if (String.valueOf(pattern.charAt(i)).equals("I")) {

                try{
                    //checks if the number is 0 and the character before it is I if it is not it generates a new random number between 1 and 9
                    if((num == 0 && !String.valueOf(pattern.charAt(i-1)).equals("I"))){
                        num += random.nextInt(1,9);
                        pattern = pattern.replaceFirst(String.valueOf((pattern.charAt(i))), String.valueOf(num));
                    }
                }catch(StringIndexOutOfBoundsException ignore){}


                pattern = pattern.replaceFirst(String.valueOf((pattern.charAt(i))), String.valueOf(num));

            }
        }

        //System.out.println(pattern);
        for (int i = 0; i < patterns.length - 3; i++) {
            formula.add(String.valueOf(pattern.charAt(i)));
        }
        System.out.println("formula before check: " + formula);
        if (!FormulaParser.validateGeneratorOutput(formula)) {
            formula.clear();
        }

        //System.out.println(formula);
        //System.out.println(FormulaParser.getResult(formula));
        //System.out.println(FormulaParser.validateGeneratorOutput(formula));
        return formula;
    }


    private void WriteToFile(ArrayList<ArrayList<String>> array) {
        // Tries overwriting a file and throws an error if not possible
        try {
            FileWriter myWriter = new FileWriter("formulas.txt");
            //loops through the array writing every line to the file
            for (ArrayList<String> strings : array) {
                String output = String.valueOf(strings);
                //removes the [] , and whitespace from the Strings
                output = output.replaceAll("[\\[\\]]|,\\s*", "");
                myWriter.write(output + "\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void GenerateFormulas(int amount) {
        ArrayList<ArrayList<String>> formulaArray = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            ArrayList<String> generatedFormula = generate();
            if (!generatedFormula.isEmpty()) {
                formulaArray.add(generatedFormula);
            }
        }
        System.out.println(formulaArray);
        WriteToFile(formulaArray);
    }
}




