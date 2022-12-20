package be.kdg.nerdle;

import java.util.ArrayList;
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

        Equation.setSizeConstraint(8);

        Try try1 = new Try(1);
        try1.guess();
        System.out.println(try1.getGuess());

    }
}
