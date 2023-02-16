package be.kdg.nerdle.model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class User {
    private String name;
    private final Map<LocalDate, Integer> scores;

    public User(String name) {
        this.name = name;
        scores = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
