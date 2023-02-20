package be.kdg.nerdle.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

public class GameSession {
    private final User user;

    private int maxTries = 8; // standard = 8, uitbreiding: andere aantal tries

    private Equation answer;

    private Board board;

    public GameSession(User user) {
        this.user = user;
        answer = getFormula();
        board = new Board();
    }

    public void setMaxTries(int maxTries) {
        this.maxTries = maxTries;
    }

    public void startSession() {

    }

    public Equation getFormula() {

        int dayNumber = LocalDate.now().getDayOfYear();
        System.out.println(dayNumber);
        String line = null;

        try {
            line = Files.readAllLines(Paths.get("formulas.txt")).get(dayNumber-1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert line != null; // moest van IntelliJ :)
        return new Equation(line);
    }

    public static void main(String[] args) {
        User u = new User("bart");
        GameSession g = new GameSession(u);
        System.out.println(g.getFormula());
    }
}

