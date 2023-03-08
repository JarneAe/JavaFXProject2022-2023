package be.kdg.nerdle;

import java.time.LocalDate;


import org.json.simple.JSONObject;

public class GameOutcome {
    private final String username;
    private final int numberOfTries;
    private final String date;

    public GameOutcome(User user, int numberOfTries) {
        this.username = user.getName();
        this.numberOfTries = numberOfTries;
        this.date = LocalDate.now().toString();
    }

    @Override
    public String toString() {
        return "GameOutcome{" +
                "username=" + username +
                ", numberOfTries=" + numberOfTries +
                ", date=" + date +
                '}';
    }

    public void writeToFile() {
        // write to json file
    }
}
