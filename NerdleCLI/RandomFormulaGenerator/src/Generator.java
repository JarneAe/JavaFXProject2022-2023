import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Generator {
    String[] possibleCharacter = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "+", "-", "*", "/"};
    //Array where the formula gets put in
    String[] operators = {"+", "-", "*", "/"};
    List<String> operatorsList = new ArrayList<>(Arrays.asList(operators));
    ArrayList<String> formula = new ArrayList<>();



    public void generate() {
        Random r = new Random();

        for (int i = 0; i < 5; i++) {
            //separates random generator for the first and last sign in the formula
            if (i == 0 || i == 4) {
                int data = r.nextInt(1, 10);
                formula.add(String.valueOf(data));
            } else {
                //random generator to generate the rest of the characters
                String data = possibleCharacter[r.nextInt(possibleCharacter.length)];
                formula.add(data);
            }
        }

        for (int i = 0; i < formula.size(); i++) {
            int amountOfOperators = 0;
            try{
                String ind1 = formula.get(i);
                String ind2 = formula.get(i+1);

                //checks if 2 indexes back to back aren't in the operators list
                if (operatorsList.contains(ind1) && operatorsList.contains(ind2)){
                    System.out.println("2 operators next to each other found!");
                }
                if(operatorsList.contains(formula.get(1)) || operatorsList.contains(formula.get(2)) || operatorsList.contains(formula.get(3))){
                    amountOfOperators++;
                }
                if(amountOfOperators < 1){
                    System.out.println("no operator found");
                }
                // error handling
            } catch (IndexOutOfBoundsException e){
                System.out.println("Index Error ( a good one ;) ) ");
            }
        }
        System.out.println(formula);

        //TODO: make sure that when a division happens it wont return a decimal number

    }
}
