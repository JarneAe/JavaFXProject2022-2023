package be.kdg.nerdle;

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
        System.out.println("session started");
        System.out.println("User: " + this.user.toString());
        System.out.println(answer);

        for (int i = 0; i < maxTries; i++) {
            Try userTry = new Try(i);
            userTry.guess();
            board.addToTries(userTry);
            board.drawBoard();

            if (userTry.getGuess().getValue().equals(answer.getValue())) {
                break;
            }
        }

        System.out.println("finished"); // record game outcome
        GameOutcome gameOutcome = new GameOutcome(user, board.getTries().size());
        gameOutcome.writeToFile();


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
