import java.util.ArrayList;
import java.util.Random;

public class Generator {
    String[] possibleCharacter = {"0","1","2","3","4","5","6","7","8","9","+","-","*","/"};
    //Array where the formula gets put in
    ArrayList<String> formula = new ArrayList<>();

    public void generate() {
        Random r = new Random();

        for (int i = 0; i < 5; i++) {
            //separates random generator for the first and last sign in the formula
            if(i == 0 || i == 4){
                int data = r.nextInt(1,10);
                formula.add(String.valueOf(data));
            }else{
                //TODO: prevent that the generator generates 2 mathematical signs next to each other
                //random generator to generate the rest of the characters
                String data = possibleCharacter[r.nextInt(possibleCharacter.length)];
                formula.add(data);
            }

        }
        //TODO: make code convert the array to the actual formula
        System.out.println(formula);

    }
}
