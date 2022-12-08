import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Generator {
    String[] possibleCharacter = {"1","2","3","4","5","6","7","8","9","+","-","*","/"};
    ArrayList<String> formula = new ArrayList<String>();

    public void generate() {
        Random r = new Random();

        for (int i = 0; i < 5; i++) {
            if(i == 0 || i == 4){
                int data = r.nextInt(1,10);
                formula.add(String.valueOf(data));
            }else{
                String data = possibleCharacter[r.nextInt(possibleCharacter.length)];
                formula.add(data);
            }

        }
        System.out.println(formula);

    }
}
