import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main { // testing rommel
    public static void main(String[] args) {
        User John = new User("John");
        User Tom = new User("Tom");
        System.out.println(John.getId());
        System.out.println(Tom.getId());

        Equation.setSizeConstraint(8);

        Scanner sc = new Scanner(System.in);
        Equation eq;

        for (int i = 0; i < 15; i++) {
            eq = new Equation(Arrays.asList(sc.nextLine().split("")));
        }

        Equation equation = new Equation(new ArrayList<>(List.of("8", "1", "-", "3", "8", "=", "4")));

        System.out.println(equation);
    }
}
