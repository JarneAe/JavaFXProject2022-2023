package be.kdg.nerdle.model;

public class User {
    private String name;
    private boolean hasPlayedToday;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", hasPlayedToday=" + hasPlayedToday +
                '}';
    }
}
