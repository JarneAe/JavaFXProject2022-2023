package be.kdg.nerdle.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

public class GameSession {
    private final User user;

    private int currentTry;

    private int maxTries = 7; // 0 tot en met 7 = 8 tries

    private final Equation answer;

    private final Board board;

    private Overview overview;

    public GameSession(User user) {
        this.user = user;
        answer = getFormula();
        board = new Board();
        overview = new Overview();
        currentTry = 0;
    }

    public User getUser() {
        return user;
    }

    public int getCurrentTry() {
        return currentTry;
    }

    public void nextTry() {
        currentTry++;
    }

    public Color getColorByBoardIndex(int i, int j) {
        return board.getColorByIndex(i, j);
    }

    public Color getColorByOverviewIndex(int i) {
        return overview.getColorByIndex(i);
    }

    public String getOverviewValueByIndex(int i) {
        return overview.getPartByIndex(i).getValue();
    }

    public void setMaxTries(int maxTries) {
        this.maxTries = maxTries;
    }

    public void updateBoard(int column, String value) {
        board.updateBoard(currentTry, column, value);
    }

    public boolean validateRow() {
        return board.validateRow(currentTry);
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

    public void assignColorsToBoardParts() {
        board.assignColorsToBoardParts(answer, currentTry);
    }
}

