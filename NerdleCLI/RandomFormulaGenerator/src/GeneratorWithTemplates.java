import java.util.Arrays;
import java.util.Random;

public class GeneratorWithTemplates {
    String[] patterns = {"II+II", "I+I+I", "II-II", "I+I-I", "I+I*I", "I*I/I"};
    Random random = new Random();

    public void generate() {


        String pattern = patterns[random.nextInt(patterns.length)];
        System.out.println(pattern);

        for (int i = 0; i < patterns.length -1; i++) {

            int num = (random.nextInt(9));
            System.out.println(num);

            if (String.valueOf(pattern.charAt(i)).equals("I")) {
                System.out.println("true");
                pattern = pattern.replace(String.valueOf((pattern.charAt(i))), String.valueOf(num));
            }
        }
        System.out.println(pattern);
    }
}
