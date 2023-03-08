package be.kdg.nerdle.model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class User implements Comparable<User> {
    private final String name;
    private final Map<LocalDate, Integer> outcomes;

    public User(String name) {
        this.name = name;
        outcomes = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                "outcomes=" + outcomes + '\'' +
                '}';
    }

    /**
     * add a score to a user
     * @param date LocalDate of the date you are trying to assign a score for. Normally always LocalDate.now(), but
     *             this was kept in for testing purposes
     * @param tries integer of the number of tries you are trying to assign
     */
    public void addToOutcomes(LocalDate date, int tries) {
        outcomes.put(date, tries);
    }

    public double getAverageTries() {
        return outcomes.values().stream().mapToDouble(d -> d).average().orElse(0.0);
    }

    public boolean hasPlayedToday() {
        return outcomes.containsKey(LocalDate.now());
    }

    @Override
    public int compareTo(User o) {
        return -Double.compare(o.getAverageTries(), getAverageTries()); // negative, because lower average tries is better
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return this.name.equals(user.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, outcomes);
    }
}
