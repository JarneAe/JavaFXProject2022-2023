package be.kdg.nerdle.model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class User {
    private final String name;
    private final Map<LocalDate, Integer> scores;

    public User(String name) {
        this.name = name;
        scores = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public Map<LocalDate, Integer> getScores() {
        return scores;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                "scores" + scores + '\'' +
                '}';
    }

    /**
     * add a score to a user
     * @param date LocalDate of the date you are trying to assign a score for. Normally always LocalDate.now(), but
     *             this was kept in for testing purposes
     * @param score integer of the score you are trying to assign
     */
    public void addToScores(LocalDate date, int score) {
        scores.put(date, score);
    }
}
