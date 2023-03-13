package be.kdg.nerdle.model;

import be.kdg.nerdle.model.jsonManager.JsonManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;

public class GameSession {
    private User user;

    private int currentTry;
    private final Equation answer;

    private final Board board;

    private final Overview overview;

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

    public void setUser(User user) {
        this.user = user;
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
    public void assignColorsToOverview() {
        overview.updateColors(board.getRow(currentTry));
    }

    public boolean hasGameEnded() {
        return board.hasGameEnded(currentTry-1);
    }

    public void handleEndOfGame() {
        JsonManager.addToOutcomesByName(user.getName(), LocalDate.now(), currentTry);
    }
}

