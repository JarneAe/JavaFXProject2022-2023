package be.kdg.nerdle;

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

        Equation.setSizeConstraint(8);

//        Equation test4 = new Equation(Arrays.asList("2", "1", "6", "/", "3", "=", "7", "2"));
//        System.out.println(test4);

        Try t = new Try(1);
        t.guess();
    }
}
