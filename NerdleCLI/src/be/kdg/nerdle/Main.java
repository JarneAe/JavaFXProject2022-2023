package be.kdg.nerdle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main { // testing rommel
    public static void main(String[] args) {
        User John = new User("John");
        User Tom = new User("Tom");
        GameSession session = new GameSession(John);
        //System.out.println(John.getId());
        //System.out.println(Tom.getId());

        Equation.setSizeConstraint(8);

        Board board = new Board();
        board.drawBoard();

        Try t = new Try(1);
        t.guess();
        board.addToTries(t);


        board.drawBoard();

    }
}
