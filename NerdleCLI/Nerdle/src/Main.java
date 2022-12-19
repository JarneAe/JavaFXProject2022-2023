import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main { // testing rommel
    public static void main(String[] args) {
        User John = new User("John");
        User Tom = new User("Tom");
        GameSession session = new GameSession();
        System.out.println(session.GetFormula());
        //System.out.println(John.getId());
        //System.out.println(Tom.getId());

        //Equation.setSizeConstraint(8);

        //Equation equation = new Equation(new ArrayList<>(List.of("8", "1", "-", "3", "8", "=", "4", "3")));

        //System.out.println(equation);
//
        Overview overview = new Overview();
        overview.display();

        overview.setColor("3", Color.BLACK);
        overview.setColor("4", Color.GREEN);
        overview.setColor("5", Color.PURPLE);
        overview.setColor("6", Color.CLEAR);

        overview.display();


//        System.out.println(ConsoleColors.GREEN + "Hello" + ConsoleColors.BLACK + " World");
    }
}
