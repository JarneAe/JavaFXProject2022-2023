package be.kdg.nerdle;

public class User {
    private static int idCount = 0;

    private String name;
    private final int id;
    private boolean hasPlayedToday;

    public User(String name) {
        idCount++;
        this.id = idCount;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", hasPlayedToday=" + hasPlayedToday +
                '}';
    }
}
