package be.kdg.nerdle;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

public class GameSession {
    private User user;

    private final int MAX_TRIES = 8;

    public GameSession(User user) {
        this.user = user;
    }

    public void startSession(User user) {
        System.out.println("session started");
        System.out.println("User: " + this.user.toString());

        Equation answer = getFormula();
        System.out.println(getFormula());
        Board board = new Board();

        for (int i = 0; i < MAX_TRIES; i++) {
            Try userTry = new Try(i);
            userTry.guess();
            board.addToTries(userTry);
            board.drawBoard();

            if (userTry.getGuess().getValue().equals(answer.getValue())) {
                break;
            }
        }

        System.out.println("finished"); // record game outcome


    }

    public Equation getFormula() {

        int dayNumber = LocalDate.now().getDayOfYear();
        String line = null;
        
        try {
            line = Files.readAllLines(Paths.get("formulas.txt")).get(dayNumber);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert line != null; // moest van IntelliJ :)
        return new Equation(List.of(line.split("")));
    }
}
